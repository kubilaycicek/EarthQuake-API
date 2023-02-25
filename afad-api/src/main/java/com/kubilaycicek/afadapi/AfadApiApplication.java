package com.kubilaycicek.afadapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AfadApiApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AfadApiApplication.class, args);
        getContent();
    }
    public static void getContent() throws IOException {


    }

}
