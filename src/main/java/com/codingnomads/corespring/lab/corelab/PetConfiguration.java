package com.codingnomads.corespring.lab.corelab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PetConfiguration {
    @Bean
    public Cat cat(){
        return new Cat(6,"Nova");
    }
    @Bean
    public Dog dog(){
        return new Dog(15,"Bella");
    }
}
