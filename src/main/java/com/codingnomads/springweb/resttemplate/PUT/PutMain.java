/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.PUT;

import com.codingnomads.springweb.resttemplate.PUT.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.PUT.models.Task;
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
public class PutMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PutMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            // use a valid task id
            int id = 16480;


            // request Task 5 from server
            User user = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + id, User.class);

            // confirm data was retrieved & avoid NullPointerExceptions
            Info infoToUpdate;
            if (user == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (user.getData() == null) {
                throw new Exception("The task with ID " + id + " could not be found");
            } else {
                infoToUpdate = user.getData();
            }

            // update the task information
            infoToUpdate.setEmail("connorputexample@example.com");
            infoToUpdate.setLast_name("PutExample");

            // use put to update the resource on the server
            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/users/" + infoToUpdate.getId(), infoToUpdate);
            // get the task to verify update
            user = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + id, User.class);
            System.out.println(user.toString());

           infoToUpdate.setEmail("connorputexchangeexample@example.com");
            //taskToUpdate.setDescription("this task was updated using RestTemplate's exchange() method - video demo 2");

            // create an HttpEntity wrapping the task to update
           HttpEntity<Info> httpEntity = new HttpEntity<>(infoToUpdate);
            // use exchange() to PUT the HttpEntity, and map the response to a ResponseEntity
           ResponseEntity<User> response = restTemplate.exchange(
                   "http://demo.codingnomads.co:8080/tasks_api/users/" + infoToUpdate.getId(),
                    HttpMethod.PUT,
                    httpEntity,
                    User.class);
            System.out.println(response.toString());
        };
    }
}
