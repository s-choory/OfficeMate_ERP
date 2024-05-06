package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class CommuteController {
	
    @GetMapping("/commute")
    public String commute() {
        return "commute/commute"; 
    }

}
