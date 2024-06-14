package com.example.javanotes.controllers.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javanotes.dtos.users.UserRequestDTO;
import com.example.javanotes.dtos.users.UserResponseDTO;
import com.example.javanotes.services.users.UsersService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.javanotes.entities.users.UsersEntity;


@RestController
@RequestMapping("/api")
public class UsersController {
    public UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService){
        this.usersService = usersService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDTO> addNote(@Valid @RequestBody UserRequestDTO usersDTO) {
        System.out.println(usersDTO);
        UserResponseDTO user = usersService.addUser(usersDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<UsersEntity>> getAllUsers() {
        List<UsersEntity> users = usersService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
}
