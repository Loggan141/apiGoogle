package com.example.forumdois.v1.controller;


import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
public class HelloWorldController {

    @RequestMapping("/")
    private String execute(){
        return "Primeira página!!!";
    }

}
