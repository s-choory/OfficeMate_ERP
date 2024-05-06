package com.example.demo.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
	
    @GetMapping("/")
    public String root(Model model) {
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    	Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    	Iterator<? extends GrantedAuthority> iter = authorities.iterator();
    	GrantedAuthority auth = iter.next();
    	String role = auth.getAuthority();
    	
    	model.addAttribute("name",name);
    	model.addAttribute("role",role);
        return "home/start" ; // index.html 렌더링
    }

    @GetMapping("/home")
    public String home() {
        return "home/home"; // home.html 렌더링
    }
    
    @GetMapping("/login")
    public String login() {
    	System.out.println(1);
        return "home/login"; // login.html 렌더링
    }
    
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "redirect:/";
    }
   
}
