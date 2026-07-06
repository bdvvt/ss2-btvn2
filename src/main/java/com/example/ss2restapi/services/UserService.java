package com.example.ss2restapi.services;

import com.example.ss2restapi.models.User;
import com.example.ss2restapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(String search) {
        if (search== null || search.isEmpty()) {
            return userRepository.findAll(search);
        }
        return userRepository.findAll(search);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(id);
    }
}
