/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.POST.postForLocation;

import com.codingnomads.springweb.resttemplate.POST.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.POST.models.Task;
import java.net.URI;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostForLocationMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForLocationMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Info newInfo = Info.builder()
                    .email("connor.postlocationexample3@example.com")
                    .first_name("Connor")
                    .last_name("PostLocation")
                    .build();

            // use postForLocation() to get the URL for the new resource
            URI returnedLocation = restTemplate.postForLocation(
                    "http://demo.codingnomads.co:8080/tasks_api/users", newInfo, User.class);

            System.out.println(Objects.requireNonNull(returnedLocation));

            //ResponseEntity<?> responseEntity = restTemplate.postForEntity(
                   // "http://demo.codingnomads.co:8080/tasks_api/users", newInfo, User.class);

            //System.out.println(responseEntity.getHeaders().get("Location"));
        };
    }
}
