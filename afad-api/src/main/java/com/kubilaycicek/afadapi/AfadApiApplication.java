package com.kubilaycicek.afadapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@EnableCaching
@SpringBootApplication
public class AfadApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfadApiApplication.class, args);
    }
}
