package com.example.demo.service;

import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.exception.UsernameAlreadyExistsException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register new user
    public User registerUser(String username, String password, boolean paidUser) {
        // Validate username and password
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        // Check if username exists
        if (userRepository.findByUsername(username) != null) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }
        // Save user
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPaidUser(paidUser);
        return userRepository.save(user);
    }

    // Login user
    public User loginUser(String username, String password) {
        // Find user by username
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid credentials");
        }
        return user;
    }

    // Find user by username
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
