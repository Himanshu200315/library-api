package com.zimetrics.library_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApiApplication.class, args);
    }

    @Bean
    CommandLineRunner printServerUrl() {
        return args -> {
            System.out.println("=======================================");
            System.out.println("🚀 Application started successfully!");
            System.out.println("🌐 Backend API: http://localhost:8080");
            System.out.println("📄 Frontend UI: http://localhost:8080/index.html");
            System.out.println("=======================================");
        };
    }
}
