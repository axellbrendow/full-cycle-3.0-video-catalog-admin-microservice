package com.axell.fullcycle.video.catalog.admin.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.axell.fullcycle.video.catalog.admin.infrastructure.configuration.WebServerConfig;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(WebServerConfig.class, args);
    }
}
