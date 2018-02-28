package com.dashboard.api.util.slack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author LEBOC Philippe
 */
@Slf4j
@Component
@ConditionalOnProperty("${slack.enabled:false}")
public final class Slack {

    @Autowired
    private RestTemplate client;

    @Value("${slack.url}")
    private String slackUrl;

    @Value("${slack.channel.info.name}")
    private String slackInfoChannel;

    @Value("${slack.channel.info.botname}")
    private String slackInfoChannelBotName;

    @Value("${slack.channel.info.boticon}")
    private String slackInfoChannelBotIcon;

    @Value("${slack.channel.warning.name}")
    private String slackWarningChannel;

    @Value("${slack.channel.warning.botname}")
    private String slackWarningChannelBotName;

    @Value("${slack.channel.warning.boticon}")
    private String slackWarningChannelBotIcon;

    /**
     * Send message to the Slack Warning channel
     * @param message The message to be sent by this application
     */
    public void sendWarning(@NotBlank @Size(min = 3) String message) {
        executePost(new SlackRequest(slackWarningChannel, slackWarningChannelBotName, message, slackWarningChannelBotIcon));
    }

    /**
     * Send message to the Slack Info channel
     * @param message The message to be sent by this application
     */
    public void sendInfo(@NotBlank @Size(min = 3) String message) {
        executePost(new SlackRequest(slackInfoChannel, slackInfoChannelBotName, message, slackInfoChannelBotIcon));
    }

    private void executePost(final SlackRequest request) {
        try
        {
            final ObjectMapper mapper = new ObjectMapper();
            final String json = mapper.writeValueAsString(request);
            client.postForEntity(slackUrl, json, Object.class);
        } catch (JsonProcessingException e) {
            log.warn("Cannot process JSON conversion of SlackRequest [{}]", request, e);
        }
    }
}
