package com.underground.c3_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//  test endpoint code
@RestController
public class TestController {
    
    @GetMapping("/api/test")
    public String testEndpoint() {
        return "CROSS CULTURE CANVAS C3 BACKEND IS RUNNING!";
    }
}
