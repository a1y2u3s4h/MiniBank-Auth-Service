package com.AuthService.MiniBank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AuthService.MiniBank.dto.LoginRequest;
import com.AuthService.MiniBank.dto.RegisterRequest;
import com.AuthService.MiniBank.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class Authcontroller {

    private final AuthService authService;

    public Authcontroller(AuthService authService) {
        this.authService = authService;
    }
    
    @GetMapping("/admin")
    public String admin() {
        return "Welcome Admin";
    }
    
    @GetMapping("/user")
    public String user() {
        return "Welcome User";
    }

    @GetMapping("/test")
    public String test() {
        return "Auth Service Running";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                authService.register(request));
    }
    
    @GetMapping("/profile")
    public String profile() {
        return "Welcome User";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                authService.login(request));
    }
}