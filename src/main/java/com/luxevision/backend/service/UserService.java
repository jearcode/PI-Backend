package com.luxevision.backend.service;

import com.luxevision.backend.dto.BookingResponse;
import com.luxevision.backend.entity.Booking;
import com.luxevision.backend.entity.User;
import com.luxevision.backend.entity.util.Role;
import com.luxevision.backend.entity.util.Status;
import com.luxevision.backend.exception.*;
import com.luxevision.backend.repository.BookingRepository;
import com.luxevision.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EmailService emailService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()))
        );
    }

    public boolean isEmailTaken(String email) {
        return userRepository.existsByEmail(email);
    }

    public User saveUser(User user) {
        String htmlContent = String.format(
                """
                <html>
                <body style="font-family: Arial, sans-serif; margin: 0; padding: 0;">
                    <div style="background-color: #f4f4f4; padding: 20px;">
                        <div style="max-width: 600px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
                            <div style="text-align: center;">
                                <img src="cid:logo" alt="LuxeVision Logo" style="width: 150px; margin-bottom: 10px;">
                            </div>
                            <h2 style="color: #555;">Registration Confirmed!</h2>
                            <p>Hello %s,</p>
                            <p>You have successfully registered with the Email: <strong>%s</strong></p><p></p>
                            <p>If you made this registration, no further action is needed. You can log in and start enjoying our services right away.</p><p></p>
                            <p>If you didn’t create this account or received this email by mistake, please contact us immediately so we can assist you.</strong></p><p></p>
                            <p>Thank you for choosing LuxeVision!</p><p></p>
                            <p style="text-align: center; color: #999; font-size: 0.9rem;">&copy; 2024 LuxeVision. All Rights Reserved.</p><p></p>
                        </div>
                    </div>
                </body>
                </html>
                """,
                user.getFirstName(),
                user.getEmail()

        );

        try {
            emailService.sendHtmlEmail(user.getEmail(), "Registration Confirmation", htmlContent);
        } catch (MessagingException e) {

            System.err.println("Fail to send email: " + e.getMessage());
            e.printStackTrace();
        }

        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDetails loadUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    public User findUserById(Long id) {

        return userRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("User not found with id: " + id)
        );

    }

    public User updateUser(User user) throws UserEmailAlreadyRegisteredException {

        User userFromDB = userRepository.findById(user.getId()).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id: " + user.getId())
        );

        if (!userFromDB.getEmail().equals(user.getEmail())) {
            if (isEmailTaken(user.getEmail())) {
                throw new UserEmailAlreadyRegisteredException();
            } else {
                userFromDB.setEmail(user.getEmail());
            }
        }
        userFromDB.setFirstName(user.getFirstName());
        userFromDB.setLastName(user.getLastName());

        if (user.getPassword() != null) {
            userFromDB.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(userFromDB);

    }

    public void deleteUserById(Long id) {

        userRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("User not found with id: " + id)
        );

        userRepository.deleteById(id);

    }

    public User findLoggedInUser() {

        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String email = userDetails.getUsername();
        
        return userRepository.findByEmail(email);

    }

    @Transactional
    public User assignRoleAdmin(Long id) {

        User userFromDB = userRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("User not found with id: " + id)
        );

        userFromDB.setRole(Role.ROLE_ADMINISTRATOR);
        return userRepository.save(userFromDB);

    }

    @Transactional
    public User revokeRoleAdmin(Long id) {

        User userFromDB = userRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("User not found with id: " + id)
        );

        userFromDB.setRole(Role.ROLE_CUSTOMER);
        return userRepository.save(userFromDB);

    }

    public User updateAuthenticatedUserProfile(User user) throws UserEmailAlreadyRegisteredException, NoChangesMadeException {

        User userFromAuth = findLoggedInUser();

        if (userFromAuth.getFirstName().equals(user.getFirstName()) && userFromAuth.getLastName().equals(user.getLastName())
                && userFromAuth.getEmail().equals(user.getEmail()) && passwordEncoder.matches(user.getPassword(), userFromAuth.getPassword())) {
            throw new NoChangesMadeException();
        }


        if (!userFromAuth.getEmail().equals(user.getEmail())) {
            if (isEmailTaken(user.getEmail())) {
                throw new UserEmailAlreadyRegisteredException();
            } else {
                userFromAuth.setEmail(user.getEmail());
            }
        }
        userFromAuth.setFirstName(user.getFirstName());
        userFromAuth.setLastName(user.getLastName());
        userFromAuth.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(userFromAuth);
    }
    public void addFavorite(Long studioId) {
        Long userId = findLoggedInUser().getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getFavStudios().contains(studioId)) {
            throw new StudioAlreadyInFavoritesException("Studio is already in favorites");
        }

        user.getFavStudios().add(studioId);
        userRepository.save(user);
    }

    public List<Long> getFavorites(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getFavStudios();
    }

    public void removeFavorite(Long userId, Long studioId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getFavStudios().contains(studioId)) {
            throw new StudioNotInFavoritesException("Studio is not in favorites");
        }

        user.getFavStudios().remove(studioId);
        userRepository.save(user);
    }

    public List<BookingResponse> findAllMyBookings () {

        User user = findLoggedInUser();

        List<Booking> bookings = bookingRepository.findAllByUserId(user.getId());

        List<BookingResponse> bookingResponses = bookings.stream()
                .map((booking) -> BookingResponse.builder()
                        .id(booking.getId())
                        .date(booking.getDate())
                        .startTime(booking.getStartTime())
                        .endTime(booking.getEndTime())
                        .totalPrice(booking.getTotalPrice())
                        .status(booking.getStatus())
                        .studioID(booking.getStudio().getId())
                        .specialtyID(booking.getSpecialty().getId())
                        .user(booking.getUser().getFirstName() + " " + booking.getUser().getLastName())
                        .build()).collect(Collectors.toUnmodifiableList());

        return bookingResponses;

    }

    public void cancelMyBooking (Long id) throws NoChangesMadeException {

        User user = findLoggedInUser();

        Booking bookingFromDB = bookingRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Booking with id " + id + " not found.")
        );

        if (!bookingFromDB.getUser().getId().equals(user.getId())) {
            throw new InvalidUserException("The user is not authorized to access or modify this booking.");
        }

        if (bookingFromDB.getStatus().equals(Status.CANCELLED)) {
            throw new NoChangesMadeException();
        }

        bookingFromDB.setStatus(Status.CANCELLED);

        bookingRepository.save(bookingFromDB);

    }

}


