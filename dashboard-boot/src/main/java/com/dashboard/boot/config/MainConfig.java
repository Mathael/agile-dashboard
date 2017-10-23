package com.dashboard.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author LEBOC Philippe
 */
@Configuration
@EnableScheduling
@EnableAsync
@EnableWebMvc
@Import(value = {
        SecurityConfig.class,
})
public class MainConfig {}
