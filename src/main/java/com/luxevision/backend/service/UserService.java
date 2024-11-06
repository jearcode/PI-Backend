package com.luxevision.backend.service;

import com.luxevision.backend.entity.CustomUserDetails;
import com.luxevision.backend.entity.User;
import com.luxevision.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

           @Autowired
        private UserRepository userRepository;



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
