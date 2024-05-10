package com.kylych.notesapp.controller;

import com.kylych.notesapp.dto.UserRegistrationDTO;
import com.kylych.notesapp.entity.User;
import com.kylych.notesapp.repository.UserRepository;
import com.kylych.notesapp.security.JwtTokenProvider;
import com.kylych.notesapp.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomUserDetailsService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserRegistrationDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO signUpRequest) {
        System.out.println("Received username: " + signUpRequest.getUsername());
        System.out.println("Received email: " + signUpRequest.getEmail());
        System.out.println("Received password: " + signUpRequest.getPassword());
        if (signUpRequest.getPassword() == null) {
            return ResponseEntity.badRequest().body("Password cannot be null");
        }

        System.out.println("Username: " + signUpRequest.getUsername() + ", Email: " + signUpRequest.getEmail());

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword());

        userService.registerUser(user);

        return ResponseEntity.ok("User registered successfully");
    }
}
