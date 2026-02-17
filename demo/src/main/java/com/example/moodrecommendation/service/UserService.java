package com.example.moodrecommendation.service;

import com.example.moodrecommendation.entity.User;
import com.example.moodrecommendation.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public String register(String username, String password) {

        if (userRepo.findByUsername(username).isPresent()) {
            return "Username already exists";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userRepo.save(user);
        return "User registered successfully";
    }

    public boolean login(String username, String password) {

        return userRepo.findByUsername(username)
                .map(u -> u.getPassword().equals(password))
                .orElse(false);
    }
}
