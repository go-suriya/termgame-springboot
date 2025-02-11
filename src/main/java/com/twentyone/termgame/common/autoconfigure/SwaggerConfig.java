package com.twentyone.termgame.common.autoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Swagger Spring Boot Example")
            .version("1.0")
            .description("This is a simple API documentation using Swagger and Spring Boot"));
  }

}
