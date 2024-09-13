package com.pluclink.api.modules.Auth.controllers;

import com.pluclink.api.modules.Auth.services.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="authenticate")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping()
    public String authenticate(Authentication authentication) {
        return authService.authenticate(authentication);
    }
}
