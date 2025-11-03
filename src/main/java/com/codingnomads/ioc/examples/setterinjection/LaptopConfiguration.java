/* CodingNomads (C)2024 */
package com.codingnomads.ioc.examples.setterinjection;

import com.codingnomads.ioc.examples.constructorinjection.GPU;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.codingnomads.ioc.examples.setterinjection")
public class LaptopConfiguration {
    @Bean
    public Processor processor() {
        return new Processor(8, "i9");
    }

    @Bean
    public OS os() {
        return new OS("ubuntu");
    }

    @Bean
    public CPU cpu() {
        return new CPU("Ryzen 7 7700x",16000);
    }
}
