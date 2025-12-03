/* CodingNomads (C)2024 */
package com.codingnomads.springtest.usingmockmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Bobbert");
        return "greeting";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String greet() {
        return "Hello Back";
    }


    @PostMapping("/hello2")
    @ResponseBody
    public String greet2() {
    return "Hola";
}

    @GetMapping("/hello3")
    @ResponseBody
    public String greet3() {
        return "Bonjour";
    }

    @GetMapping("/hello/{name}")
    public String nameGreet(@PathVariable("name") String name, Model model)
    {
        model.addAttribute("name",name);
        return "greeting";
    }

    @GetMapping("/empty")
    @ResponseBody
    public String emptyString() {
        return "";
    }

}

