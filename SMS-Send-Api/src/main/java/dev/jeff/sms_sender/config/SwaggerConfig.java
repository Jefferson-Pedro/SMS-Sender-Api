package dev.jeff.sms_sender.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("smssenderapi-public")
                .pathsToMatch("/send-sms/**")
                .build();
    }
}
