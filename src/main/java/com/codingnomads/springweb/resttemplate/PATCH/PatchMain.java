/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.PATCH;

import com.codingnomads.springweb.resttemplate.PATCH.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.PATCH.models.Task;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PatchMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PatchMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            // create an empty Task
            Info info = new Info();
            Info info2= new Info();
            // be sure to use a valid task id
            info.setId(16477);
            info2.setId(16480);

            // set fields you want to change. All other fields are null and will not be updated
            info.setLast_name("PatchExample");
            info2.setLast_name("PatchExample2");
            // send the PATCH request using the URL, the Task created above and the ResponseObject Class
            User userResponse = restTemplate.patchForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + info.getId(), info, User.class);

            User userResponse2 = restTemplate.patchForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + info2.getId(), info2, User.class);

            System.out.println(Objects.requireNonNull(userResponse));
            System.out.println(Objects.requireNonNull(userResponse2));

            info.setEmail("patchexample@example.com");
            info.setLast_name("PatchExchangeExample");

            info2.setEmail("patchexample2@example.com");
            info2.setLast_name("PatchExchangeExample2");

            HttpEntity<Info> httpEntity = new HttpEntity<>(info);
            HttpEntity<Info> httpEntity2 = new HttpEntity<>(info2);
            ResponseEntity<User> response = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + info.getId(),
                    HttpMethod.PATCH,
                    httpEntity,
                    User.class);

            ResponseEntity<User> response2 = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + info2.getId(),
                    HttpMethod.PATCH,
                    httpEntity2,
                    User.class);

            System.out.println(Objects.requireNonNull(response));
            System.out.println(Objects.requireNonNull(response2));
        };
    }
}
