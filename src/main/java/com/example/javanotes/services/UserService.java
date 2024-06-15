package com.example.javanotes.services;

import java.util.List;

import com.example.javanotes.dto.user.UserRequestDTO;
import com.example.javanotes.dto.user.UserResponseDTO;
import com.example.javanotes.entities.User;

public interface UserService {
    UserResponseDTO addUser(UserRequestDTO usersDTO);

    List<User> getAllUsers();
}
