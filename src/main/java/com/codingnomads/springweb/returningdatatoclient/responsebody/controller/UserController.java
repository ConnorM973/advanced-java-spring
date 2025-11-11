/* CodingNomads (C)2024 */
package com.codingnomads.springweb.returningdatatoclient.responsebody.controller;

import com.codingnomads.springweb.returningdatatoclient.responsebody.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    public User user = User.builder()
            .id(1000)
            .name("Spring Dev")
            .email("dev@codingnomads.com")
            .build();

    public User user2 = User.builder()
            .id(2000)
            .name("Connor McCaffrey")
            .email("connor.mccaffrey973@gmail.com")
            .build();
    public User user3 = User.builder()
            .id(3000)
            .name("John Smith")
            .email("johnsmith@gmail.com")
            .build();
    public User user4 = User.builder()
            .id(3000)
            .name("Bob Bobson")
            .email("bobbobson@sbcglobal.net")
            .build();
    public List<User> allUsers = List.of(user, user2, user3, user4);
    public List<User> allUsers2 = new ArrayList<>() {{
        this.add(user);
        this.add(user2);
        this.add(user3);
        this.add(user4);
    }};


    // using ResponseBody to return a POJO
    @ResponseBody
    @GetMapping("/response-body")
    public User userResponseBody() {
        return user;
    }

    // using ResponseEntity to return POJO
    @GetMapping("/response-entity")
    public ResponseEntity<User> userResponseEntity() {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // returning a POJO without ResponseBody or using a ResponseEntity - error expected
    @GetMapping("/user")
    public User user() {
        return user;
    }

    @ResponseBody
    @GetMapping("/user-list")
    public List<User> getAllUsers(){
        return allUsers;

    }
}

