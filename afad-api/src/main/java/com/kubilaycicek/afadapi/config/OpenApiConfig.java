package com.kubilaycicek.afadapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Earthquake REST API")
                        .summary("V.1.0")
                        .description("EarthQuake Rest API")
                        .contact(new Contact()
                                .email("kubilaycicek0693@gmail.com")
                                .name("Kubilay ÇİÇEK"))
                        .license(new License().name("Licence"))
                );
    }
}
