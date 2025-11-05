/* CodingNomads (C)2024 */
package com.codingnomads.springweb.springrestcontrollers.simpledemo.controller;

import com.codingnomads.springweb.springrestcontrollers.simpledemo.Cat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/goodbye/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String goodbye(@PathVariable(name = "name") String name) {
        String goodbye1= "Goodbye "+name;
        String goodbye2= "Adios "+name;
        String goodbye3= "Au revoir "+name;
        List<String> goodbyeList= new ArrayList<>();
        goodbyeList.add(goodbye1);
        goodbyeList.add(goodbye2);
        goodbyeList.add(goodbye3);
        return goodbyeList.toString();
    }

    @RequestMapping(path = "/cat", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String catExample() {
        Cat cat= new Cat("Tigger",7,"Orange");
        return cat.toString();
    }


}
