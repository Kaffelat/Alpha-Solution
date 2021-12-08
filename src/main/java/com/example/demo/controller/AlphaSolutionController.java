package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlphaSolutionController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/createProject")
    public String createProject(){
    return "createProject";
    }

    @GetMapping("/seeProjects")
    public String seeProjects(){
        return "seeProjects";
    }

}