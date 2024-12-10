package com.luxevision.backend.controller;

import com.luxevision.backend.dto.*;
import com.luxevision.backend.dto.auth.*;
import com.luxevision.backend.exception.*;
import com.luxevision.backend.service.TokenService;
import com.luxevision.backend.service.auth.JwtService;
import com.luxevision.backend.entity.User;
import com.luxevision.backend.entity.util.Role;
import com.luxevision.backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid SaveUser saveUser) throws UserEmailAlreadyRegisteredException {

        if (userService.isEmailTaken(saveUser.getEmail())) {
            throw new UserEmailAlreadyRegisteredException();
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

    @GetMapping
    public ResponseEntity<List<?>> findAllUsers() {

        List<User> users = userService.getAllUsers();

        List<UserAdminView> userAdminViewList = users.stream()
                .map(user -> UserAdminView.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .role(user.getRole().name())
                        .signupDate(user.getSignupDate())
                        .enabled(user.isEnabled())
                        .build()
                )
                .collect(Collectors.toList());

        return ResponseEntity.ok(userAdminViewList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById (@PathVariable Long id) {

        return ResponseEntity.ok(userService.findUserById(id));

    }

    @PutMapping
    public ResponseEntity<User> updateUser (@RequestBody @Valid UserUpdateRequest userUpdateRequest) throws UserEmailAlreadyRegisteredException {

        User user = new User();
        user.setId(userUpdateRequest.getId());
        user.setFirstName(userUpdateRequest.getFirstName());
        user.setLastName(userUpdateRequest.getLastName());
        user.setEmail(userUpdateRequest.getEmail());
        user.setPassword(userUpdateRequest.getPassword());

        return ResponseEntity.ok(userService.updateUser(user));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById (@PathVariable Long id) {

        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/profile")
    public ResponseEntity<UserViewProfileResponse> findMyProfile () {
        User user = userService.findLoggedInUser();

        return ResponseEntity.ok(UserViewProfileResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build());
    }

    @PutMapping("/{id}/promote")
    public ResponseEntity<User> assignAdmin (@PathVariable Long id) {
        User user = userService.assignRoleAdmin(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}/demote")
    public ResponseEntity<User> revokeAdmin (@PathVariable Long id) {
        User user = userService.revokeRoleAdmin(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/self")
    public ResponseEntity<?> updateAuthenticatedUserProfile (@RequestBody @Valid UserAuthUpdateRequest userAuthUpdateRequest) throws UserEmailAlreadyRegisteredException, NoChangesMadeException {

        User user = new User();
        user.setFirstName(userAuthUpdateRequest.getFirstName());
        user.setLastName(userAuthUpdateRequest.getLastName());
        user.setEmail(userAuthUpdateRequest.getEmail());
        user.setPassword(userAuthUpdateRequest.getPassword());

        User updatedUser = userService.updateAuthenticatedUserProfile(user);

        String jwt = jwtService.generateToken(updatedUser, generateExtraClaims(updatedUser));

        return ResponseEntity.ok(UserAuthUpdateResponse.builder()
                .id(updatedUser.getId())
                .firstName(updatedUser.getFirstName())
                .lastName(updatedUser.getLastName())
                .email(updatedUser.getEmail())
                .role(updatedUser.getRole().name())
                .jwt(jwt)
                .build());

    }

        @PostMapping("/logout")
        public ResponseEntity<?> logout(HttpServletRequest request) {
            String token = request.getHeader("Authorization");

            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
                tokenService.revokeToken(token);
                return ResponseEntity.ok("Logout successful. Token has been revoked.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No valid token provided.");
            }
        }
    @PostMapping
    public ResponseEntity<?> addFavorite(@RequestBody FavoriteRequest request) {
        userService.addFavorite(request.getStudioId());
        return ResponseEntity.ok("Studio added to favorites.");
    }

    @GetMapping("/favorites")
    public ResponseEntity<FavoriteResponse> getFavorites() {
        User user = userService.findLoggedInUser();

        FavoriteResponse response = new FavoriteResponse();
        response.setStudios(user.getFavStudios());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/favorites/{studioId}")
    public ResponseEntity<?> removeFavorite(@PathVariable Long studioId) {
        userService.removeFavorite(userService.findLoggedInUser().getId(), studioId);
        return ResponseEntity.ok("Studio removed from favorites.");
    }


    @GetMapping("/reservations")
    public ResponseEntity<?> findMyReservations () {

        return ResponseEntity.ok(userService.findAllMyBookings());

    }

    @PutMapping("/reservations/{id}/cancel")
    public ResponseEntity<?> cancelReservation (@PathVariable Long id) throws NoChangesMadeException {

        userService.cancelMyBooking(id);

        return ResponseEntity.ok("Booking has been cancelled.");

    }


}


