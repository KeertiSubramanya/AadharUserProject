package com.dronezzfly.onetoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dronezzfly.onetoone")
public class OnetooneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnetooneApplication.class, args);
    }

}
