package com.project.dmsport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DmSportApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmSportApplication.class, args);
    }

}