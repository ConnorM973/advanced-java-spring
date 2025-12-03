package com.codingnomads.springtest.understandingandusingprofiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("printMessage")
public class PrintMessageConfiguration{

    @Bean
    public String messageBean() {
        String message = "PrintMessage profile is active.";
        System.out.println(message);
        return message;
    }
}
