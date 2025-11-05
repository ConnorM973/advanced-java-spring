/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.DELETE;

import com.codingnomads.springweb.resttemplate.DELETE.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.DELETE.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DeleteMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DeleteMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Info newInfo = Info.builder()
                    .email("connordeleteexample@example.com")
                    .first_name("Connor")
                    .last_name("McCaffrey")
                    .build();

            // POST new task to server
            User user = restTemplate.postForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/", newInfo, User.class);

            // confirm data was returned & avoid NullPointerExceptions
            if (user == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (user.getData() == null) {
                throw new Exception("The server encountered this error while creating the task:"
                        + user.getError().getMessage());
            } else {
                newInfo = user.getData();
            }

            System.out.println("The task was successfully created");
            System.out.println(newInfo);

            // delete the newTask using the ID the server returned
            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/users/" + newInfo.getId());
            System.out.println("The task was also successfully deleted");

            // try to GET, verify record was deleted
            try {
                restTemplate.getForEntity(
                        "http://demo.codingnomads.co:8080/tasks_api/users/" + newInfo.getId(), User.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            // delete using exchange()
            HttpEntity<Info> httpEntity = new HttpEntity<>(newInfo);
            try {
                restTemplate.exchange(
                        "http://demo.codingnomads.co:8080/tasks_api/tasks/" + newInfo.getId(),
                        HttpMethod.DELETE,
                        httpEntity,
                        User.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
