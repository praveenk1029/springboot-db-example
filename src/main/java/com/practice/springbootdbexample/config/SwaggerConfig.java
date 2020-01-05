package com.practice.springbootdbexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.practice.springbootdbexample"))
               // .paths(regex("/rest.*"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot DB Swagger Example",
                "Spring Boot DB Swagger Example with Authorization",
                "1.0",
                "Terms of Service",
                new Contact("Developers", "https://www.youtube.com",
                        "praveenkp466@gmail.com"),
                "My License Version 2.0",
                "https://www.google.com"
        );
        return apiInfo;
    }
}
