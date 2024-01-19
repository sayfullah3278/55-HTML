package com.example.hospitalManagemente.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class homeController {

    @GetMapping("Home")
    public  String home(){
        return "index";
    }



}
