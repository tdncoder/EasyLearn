package com.easy.learn.web.configure;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfigure {
    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.setConnectTimeout(Duration.ofMillis(300000))
//                .setReadTimeout(Duration.ofMillis(300000))
//                .build();
//    }
}
