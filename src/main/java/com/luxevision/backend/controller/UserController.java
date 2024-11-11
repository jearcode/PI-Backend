package com.luxevision.backend.controller;

import com.luxevision.backend.dto.SaveUser;
import com.luxevision.backend.dto.auth.LoginRequest;
import com.luxevision.backend.dto.auth.LoginResponse;
import com.luxevision.backend.exception.InvalidPasswordException;
import com.luxevision.backend.service.auth.JwtService;
import com.luxevision.backend.dto.ApiError;
import com.luxevision.backend.dto.RegisteredUser;
import com.luxevision.backend.entity.User;
import com.luxevision.backend.entity.util.Role;
import com.luxevision.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> registerUser(@RequestBody SaveUser saveUser) {

        if (userService.isEmailTaken(saveUser.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered.");
        }

        if (!saveUser.getPassword().equals(saveUser.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords do not match.");
        }

        User user = new User();
        user.setFirstName(saveUser.getFirstName());
        user.setLastName(saveUser.getLastName());
        user.setEmail(saveUser.getEmail());
        user.setPassword(passwordEncoder.encode(saveUser.getPassword()));
        user.setRole(Role.ROLE_CUSTOMER);


        User userSaved = userService.saveUser(user);

        RegisteredUser userDTO = new RegisteredUser();
        userDTO.setId(userSaved.getId());
        userDTO.setFirstName(saveUser.getFirstName());
        userDTO.setLastName(saveUser.getLastName());
        userDTO.setEmail(userSaved.getEmail());

        String jwt = jwtService.generateToken(userSaved, generateExtraClaims(userSaved));
        userDTO.setJwt(jwt);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);

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
        String token = jwtService.generateToken(user, generateExtraClaims(user));
        LoginResponse logResp = new LoginResponse();
        logResp.setJwt(token);
        return ResponseEntity.ok(logResp);
    }

    private Map<String, Object> generateExtraClaims (User user) {

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("firstName", user.getFirstName());
        extraClaims.put("role", user.getRole().name());
        extraClaims.put("authorities", user.getAuthorities());

        return extraClaims;

    }

}
