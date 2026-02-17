package com.example.moodrecommendation.controller;

import com.example.moodrecommendation.dto.AuthRequest;
import com.example.moodrecommendation.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class Authcontroller {

    private final UserService userService;

    public Authcontroller(UserService userService) {
        this.userService = userService;
    }

    // REGISTER (JSON BODY)
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody AuthRequest request) {

        return ResponseEntity.ok(
                userService.register(
                        request.getUsername(),
                        request.getPassword()
                )
        );
    }

    // LOGIN (JSON BODY)
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody AuthRequest request) {

        boolean isValid = userService.login(
                request.getUsername(),
                request.getPassword()
        );

        if (isValid) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(401)
                .body("Invalid username or password");
    }
}
