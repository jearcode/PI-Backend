package com.luxevision.backend.controller;

import com.luxevision.backend.service.auth.JwtService;
import com.luxevision.backend.dto.ApiError;
import com.luxevision.backend.dto.LoginRequest;
import com.luxevision.backend.dto.UserResponse;
import com.luxevision.backend.entity.User;
import com.luxevision.backend.entity.UserRole;
import com.luxevision.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.isEmailTaken(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.ROLE_USER);
        userService.saveUser(user);

        // Genera el token para el nuevo usuario
        String token = jwtService.generateToken(user);

        // Crea y retorna el DTO de respuesta
        UserResponse response = new UserResponse();
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setToken(token);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());
        if (user == null) {
            ApiError apiError = new ApiError();
            apiError.setTimestamp(LocalDateTime.now());
            apiError.setError("User Not Found");
            apiError.setMessage("The email provided does not exist in our system.");
            apiError.setMethod("POST");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            ApiError apiError = new ApiError();
            apiError.setTimestamp(LocalDateTime.now());
            apiError.setError("Invalid Credentials");
            apiError.setMessage("The credentials provided are incorrect.");
            apiError.setMethod("POST");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
        }
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}
