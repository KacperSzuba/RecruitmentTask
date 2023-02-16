package com.recruitment.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class NbpRestTemplateConfig {

    @Bean
    RestTemplate nbpRestTemplate() {
        return new RestTemplate();
    }

}
