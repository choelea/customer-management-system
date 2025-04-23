package com.management.controller;

/**
 * @ClassName : LoginController
 * @Description :
 * @Author Franky
 * @Date 2025/4/22 21:45
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/customers";
    }
}