package com.example.ss2restapi.controllers;

import com.example.ss2restapi.models.User;
import com.example.ss2restapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(name = "search", defaultValue = "") String search) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAllUsers(search));
    }
}

