package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// react index...
@Controller
public class SinglePageController {
    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }
    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
}
