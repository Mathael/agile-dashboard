package com.dashboard.boot.startup;

import com.dashboard.api.annotation.profiles.Prod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author LEBOC Philippe
 */
@Slf4j
@Prod
@Component
public class PreprodDataInitializer {

    @EventListener(ContextRefreshedEvent.class)
    public void initialize() {
        log.info("Preprod Initializer started");
    }
}
