package com.example.Bookstore.Controllers;




import com.example.Bookstore.Entities.Role;
import com.example.Bookstore.Entities.User;
import com.example.Bookstore.Repositories.UserRepository;
import com.example.Bookstore.Dto.LoginRequest;
import com.example.Bookstore.Dto.RegisterRequest;
import com.example.Bookstore.Security.JwtUtil;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role role = (request.getRole() != null && !request.getRole().isEmpty())
                ? Role.valueOf(request.getRole().toUpperCase())
                : Role.CUSTOMER;

        user.setRole(role);
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String accessToken = jwtUtil.generateAccessToken(
                user.getEmail(),
                user.getRole().name()
        );


        String refreshToken = jwtUtil.generateRefreshToken(
                user.getEmail()
        );

        return ResponseEntity.ok(
                Map.of(
                        "accessToken", accessToken,
                        "refreshToken", refreshToken
                )
        );
    }}
