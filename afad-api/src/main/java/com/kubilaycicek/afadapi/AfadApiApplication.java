package com.kubilaycicek.afadapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AfadApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfadApiApplication.class, args);
    }
}
