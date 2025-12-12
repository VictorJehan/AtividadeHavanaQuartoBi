package com.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("  SISTEMA BIBLIOTECA - INICIADO  ");
        System.out.println("  Acesse: http://localhost:8080");
        System.out.println("========================================\n");
    }
}