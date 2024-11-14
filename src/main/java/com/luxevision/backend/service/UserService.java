package com.luxevision.backend.service;

import com.luxevision.backend.entity.User;
import com.luxevision.backend.entity.util.Role;
import com.luxevision.backend.exception.NoChangesMadeException;
import com.luxevision.backend.exception.ObjectNotFoundException;
import com.luxevision.backend.exception.UserEmailAlreadyRegisteredException;
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

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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



}
