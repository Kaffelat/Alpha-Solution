package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//Simon Bøg Jørgensen
@Controller
public class FrontPageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}