package com.datacenter.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("🏢 سامانه مدیریت دیتاسنتر")
                        .version("v1.0.0")
                        .description("سامانه جامع برای مدیریت مکان‌ها، مرکز داده‌ها، رک‌ها، تجهیزات و ارتباطات در دیتاسنتر")
                        .contact(new Contact()
                                .name("تیم توسعه دیتاسنتر")
                                .email("support@datacenter.example.com")
                                .url("https://datacenter.example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("مستندات کامل سامانه مدیریت دیتاسنتر")
                        .url("https://datacenter.example.com/docs"));
    }
}
