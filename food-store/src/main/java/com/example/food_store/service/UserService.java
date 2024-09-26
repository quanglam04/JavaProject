package com.example.food_store.service;

import org.springframework.stereotype.Service;

import com.example.food_store.domain.User;
import com.example.food_store.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "hello from service";
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }
}
