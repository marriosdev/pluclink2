package com.pluclink.api.security.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pluclink.api.modules.User.models.User;
import com.pluclink.api.security.dtos.LoginResponseDto;
import com.pluclink.api.security.dtos.LoginUserDto;
import com.pluclink.api.security.dtos.RegisterUserDto;
import com.pluclink.api.security.services.AuthenticationService;
import com.pluclink.api.security.services.JwtService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping(value="/auth")
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    
    @Autowired
    private JwtService jwtService;

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto dto) {
        User user = authenticationService.signup(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto dto) {
        User authenticatedUser = authenticationService.authenticate(dto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setExpiresIn(jwtService.getExpirationTime());
        loginResponseDto.setToken(jwtToken);
        return ResponseEntity.ok(loginResponseDto);
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) ((org.springframework.security.core.Authentication) authentication).getPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(currentUser);
    }
}
