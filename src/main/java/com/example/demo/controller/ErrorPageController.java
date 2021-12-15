package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController {

    @GetMapping("/error")
    public String errorPage(){
        return "An error has appeared. Please check that the information you put in is correct";
    }

}
