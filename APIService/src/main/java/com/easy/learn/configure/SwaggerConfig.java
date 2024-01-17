 package com.easy.learn.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String REGEX_API = "/api/v1.*";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex(REGEX_API))
                .build();
    }

    /**
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Easy Learn",
                "1.0",
                "Terms of service",
                new Contact("easyLearn", "www.example.com", "easyLearn@gmail.com"),
                "MIT-License", "https://en.wikipedia.org/wiki/MIT_License", Collections.emptyList());
    }

    //end http://localhost:9090/swagger-ui.html
}