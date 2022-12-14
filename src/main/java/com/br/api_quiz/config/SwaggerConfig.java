package com.br.api_quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class SwaggerConfig {
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.br.api_quiz.controllers"))
        .build()
        .apiInfo(metaData());
    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
        .title("API REST Quiz")
        .description("API REST for quiz")
        .version("1.0.0")
        .contact(new Contact("Sanny Helen Lima", "https://github.com/SannyHL/quiz_api", "sannysilvalima@gmail.com"))
        .build();
    }
}
