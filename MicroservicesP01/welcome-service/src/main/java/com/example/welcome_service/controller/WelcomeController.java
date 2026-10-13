
package com.example.welcome_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

    private final RestTemplate restTemplate;

    public WelcomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/welcome")
    public String welcome() {

        String helloMessage = restTemplate.getForObject(
                "http://hello-service/hello",
                String.class
        );

        return "Welcome Service says: Welcome! | "
                + "Hello Service says: " + helloMessage;
    }
}
