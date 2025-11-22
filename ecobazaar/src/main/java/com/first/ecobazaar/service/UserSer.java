
package com.first.ecobazaar.service;

import com.first.ecobazaar.entity.UserEntity;
import com.first.ecobazaar.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserSer {
    @Autowired
    private UserRepo repo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity registerUser(UserEntity user) {
        System.out.println("Registering user: " + user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity savedUser = repo.save(user);
        System.out.println("User saved with ID: " + savedUser.getUserId());
        return savedUser;
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = repo.findAll();
        System.out.println("Found " + users.size() + " users in database");
        return users;
    }
    
    public String authenticateUser(String email, String password) {
        UserEntity user = repo.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return "Login successful. Role: " + user.getRole();
        }
        return "Invalid credentials";
    }
    
    public UserEntity getUserById(Long userId) {
        return repo.findById(userId).orElse(null);
    }
}
