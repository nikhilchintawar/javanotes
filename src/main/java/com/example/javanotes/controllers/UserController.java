package com.example.javanotes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.javanotes.dto.user.UserRequestDTO;
import com.example.javanotes.dto.user.UserResponseDTO;
import com.example.javanotes.entities.User;
import com.example.javanotes.services.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
    public UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDTO> addNote(@Valid @RequestBody UserRequestDTO usersDTO) {
        System.out.println(usersDTO);
        UserResponseDTO user = userService.addUser(usersDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
}
