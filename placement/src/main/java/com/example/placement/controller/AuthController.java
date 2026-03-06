package com.example.placement.controller;

import com.example.placement.entity.Role;
import com.example.placement.entity.UserEntity;
import com.example.placement.security.JwtUtil;
import com.example.placement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody UserEntity user){
        user.setRole(Role.ROLE_STUDENT);
        userService.saveUser(user);
        return "User registered";

    }
    @PostMapping("/login")
    public String login(@RequestBody UserEntity user){
        if (userService.checkLogin(user.getEmail(),user.getPassword())){
            return jwtUtil.generateToken(user.getEmail());
        }
        return "Invalid user";
    }
}
