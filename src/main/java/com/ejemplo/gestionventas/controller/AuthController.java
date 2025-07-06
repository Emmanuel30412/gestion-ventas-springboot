package com.ejemplo.gestionventas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.gestionventas.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login") 
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password ) {
       var auth = authManager.authenticate(
        new UsernamePasswordAuthenticationToken(username, password)
       );   

       String token = jwtUtil.generarToken(username);
              return ResponseEntity.ok().body("{\"token\":\"" + token + "\"}");

    }
}
