package org.luvom.mockmicroservices.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI mockMicroservicesOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Mock Microservices API")
                        .description("Mock implementation of microservices for testing")
                        .version("v1.0"));
    }
}
