package com.jobportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "message", "Job Portal API is LIVE!",
            "status", "Running on Render",
            "register", "/api/users/register",
            "login", "/api/users/login"
        );
    }

    @GetMapping("/health")
    public String health() {
        return "OK - API is healthy";
    }
}
