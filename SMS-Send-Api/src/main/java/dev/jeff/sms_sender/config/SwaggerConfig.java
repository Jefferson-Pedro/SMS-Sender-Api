package dev.jeff.sms_sender.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("smssenderapi-public")
                .pathsToMatch("/send-sms/**")
                .pathsToMatch("/findAll")
                .pathsToMatch("/{id}")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SMS Send API")
                        .description("Projeto para envio de SMS com Twilio")
                        .version("v2.7.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Sms Send Documentation")
                        .url("https://github.com/Jefferson-Pedro/SMS-Sender-Api/blob/main/README.md"));
    }


}
