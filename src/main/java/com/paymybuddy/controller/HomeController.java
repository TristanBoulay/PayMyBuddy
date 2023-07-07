package com.paymybuddy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @GetMapping("/login")
    public String login()
    {
        return "logins";
    }

    @GetMapping("/home")
    public String home()
    {
        return "home";
    }
}
