package com.dashboard.api.util.slack;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Object used to send a Slack request to a specific channel
 * Attributes names correspond to the Slack attributes
 * @author LEBOC Philippe
 */
@Getter
@Setter
@AllArgsConstructor
public final class SlackRequest {
    private String channel;
    private String username;
    private String text;
    @JsonProperty("icon_emoji")
    private String iconEmoji;
}
