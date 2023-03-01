package com.kubilaycicek.afadapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.IOException;

@EnableCaching
@SpringBootApplication
public class AfadApiApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AfadApiApplication.class, args);
    }
}
