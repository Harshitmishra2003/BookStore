package com.example.Bookstore.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Bookstore.Dto.AuthResponse;
import com.example.Bookstore.Dto.LoginRequest;
import com.example.Bookstore.Dto.RegisterRequest;
import com.example.Bookstore.Entities.User;
import com.example.Bookstore.Repositories.UserRepository;
import com.example.Bookstore.Security.JwtUtil;
import com.example.Bookstore.Entities.Role;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwt;

    public User register(RegisterRequest req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(encoder.encode(req.getPassword()));
        user.setRole(Role.valueOf(req.getRole())); 
        return userRepo.save(user);
    }


    public AuthResponse login(LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }

        String accessToken = jwt.generateAccessToken(
                user.getEmail(),
                user.getRole().name() 
        );

        String refreshToken = jwt.generateRefreshToken(
                user.getEmail()
        );

        return new AuthResponse(accessToken, refreshToken);
    }
}