package com.product.apirest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.product.apirest"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaInfo()
            );
    }

    private ApiInfo metaInfo() {
        return new ApiInfo("Products API REST", "API REST of product registration.", "1.0", "Terms Of Service",
                new Contact("Natal", "https://github.com/NatalNW", "natanaelweslley9@gmail.com"), "The MIT License",
                "https://opensource.org/licenses/MIT", new ArrayList<VendorExtension>()
            );
    }
}