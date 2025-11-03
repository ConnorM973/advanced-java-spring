package com.codingnomads.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class ExampleConfiguration {
    @Bean
    public Framework framework2() {
        return new Framework();
    }
}
