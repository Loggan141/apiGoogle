package com.example.forumdois.controller;


import com.example.forumdois.model.Funcionario;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    private String execute(){
        return "Primeira página!!!";
    }

}
