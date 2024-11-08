package com.luxevision.backend.service;

import com.luxevision.backend.entity.CustomUserDetails;
import com.luxevision.backend.entity.User;
import com.luxevision.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
           @Autowired
        private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole().name()))
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
        return new CustomUserDetails(user);
    }

}
