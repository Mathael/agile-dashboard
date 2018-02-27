package com.dashboard.boot.startup;

import com.dashboard.api.annotation.profiles.Dev;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author LEBOC Philippe
 */
@Dev
@Slf4j
@Component
public class DevDataInitializer {

    @EventListener(ContextRefreshedEvent.class)
    public void initialize() {
        log.info("Dev Initializer started");
    }
}
