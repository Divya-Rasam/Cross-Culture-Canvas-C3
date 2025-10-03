package com.underground.c3_backend.config;

// Configure Spring Security
import  org.springframework.context.annotation.Bean;
import  org.springframework.context.annotation.Configuration;
import  org.springframework.security.config.annotation.web.builders.HttpSecurity;
import  org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/test").permitAll()            //Allow public access to /api/test
                .anyRequest().authenticated()                        // Require authentication for all other requests
            )
            .formLogin(form -> form
                .loginPage("/login")                                 //Use default login page
                .permitAll()
            );

        return http.build();

    }
}
