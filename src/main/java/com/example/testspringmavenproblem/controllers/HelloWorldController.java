package com.example.testspringmavenproblem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {

    @RequestMapping ("/hello-world")
    public @ResponseBody String helloWorld() {
        return "Hello World";
    }
}
