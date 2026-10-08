package com.example.SpringSecurityP01.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user/home")
    public String userHome(Authentication authentication) {

        return "Welcome USER: " + authentication.getName();
    }

    @GetMapping("/admin/home")
    public String adminHome(Authentication authentication) {

        return "Welcome ADMIN: " + authentication.getName();
    }

    @GetMapping("/hello")
    public String hello() {

        return "Hello! You are authenticated.";
    }
}