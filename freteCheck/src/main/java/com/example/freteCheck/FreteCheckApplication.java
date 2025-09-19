package com.example.freteCheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.freteCheck.Repository.sql")
public class FreteCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreteCheckApplication.class, args);
    }
}

