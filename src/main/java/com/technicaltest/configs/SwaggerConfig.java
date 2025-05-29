package com.technicaltest.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API rest technial test")
                        .description("this is a technical test for a rest api")
                        .version("1.0")
                        .contact(new Contact().name("ilich valbuena")))
                .components(null);
    }
}
