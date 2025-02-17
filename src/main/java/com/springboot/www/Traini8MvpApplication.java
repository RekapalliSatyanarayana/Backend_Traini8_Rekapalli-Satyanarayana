package com.springboot.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.www"})
public class Traini8MvpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Traini8MvpApplication.class, args);
    }
}
