/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.GET.getForEntity;

import com.codingnomads.springweb.resttemplate.GET.models.QuoteTemplate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GetForEntityDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForEntityDemo.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            String URL= "https://bored.api.lewagon.com/api/activity?minaccessibility={minAccessibility}&maxaccessibility={maxAccessibility}";

            Map<String,Integer> params= new HashMap<>();
            params.put("minAccessibility",0);
            params.put("maxAccessibility",1);

            ResponseEntity<Response> responseEntity =
                    restTemplate.getForEntity(URL, Response.class,params);

            if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
                Response response = responseEntity.getBody();
                System.out.println(response.toString());
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }
        };
    }
}
