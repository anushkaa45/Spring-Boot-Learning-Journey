
package com.example.admin_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public String adminHome() {
        return "Welcome to Admin Service!";
    }

    @GetMapping("/admin/status")
    public String adminStatus() {
        return "Admin Service is running successfully!";
    }

    @GetMapping("/admin/services")
    public String services() {
        return "Available services: Hello Service, Welcome Service, Admin Service";
    }
}
