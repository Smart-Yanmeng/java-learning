package com.york.eyesight.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SpringBoot API Test")
                        .description("SpringBoot3.2.4 Application with SpringDoc2.5.0.")
                        .version("0.0.1"));
    }
}
