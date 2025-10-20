package com.underground.c3_backend.controller.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.underground.c3_backend.dto.UserRegistrationDto;
import com.underground.c3_backend.entities.User;
import com.underground.c3_backend.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        try {
            User user = userService.createUser(registrationDto);
            
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User registered successfully");
            response.put("userId", user.getId());
            response.put("username", user.getUsername());
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/check-username/{username}")
    public ResponseEntity<?> checkUsernameAvailability(@PathVariable String username) {
        boolean available = !userService.findByUsername(username).isPresent();
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("available", available);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/check-email/{email}")
    public ResponseEntity<?> checkEmailAvailability(@PathVariable String email) {
        boolean available = !userService.findByEmail(email).isPresent();
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("available", available);
        
        return ResponseEntity.ok(response);
    }
}