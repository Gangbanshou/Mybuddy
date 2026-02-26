package com.mybuddy.backend.controller;

import com.mybuddy.backend.entity.User;
import com.mybuddy.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> req) {
        User user = new User();
        user.setPhone(req.get("phone"));
        user.setPasswordHash(passwordEncoder.encode(req.get("password")));
        return userRepository.save(user);
    }
}
