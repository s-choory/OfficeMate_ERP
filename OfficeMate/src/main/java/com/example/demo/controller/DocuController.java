package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DocuController {
	
    @GetMapping("/docu")
    public String docu() {
        return "docu/docu"; 
    }

}
