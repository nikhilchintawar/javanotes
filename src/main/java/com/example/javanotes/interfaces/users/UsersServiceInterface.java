package com.example.javanotes.interfaces.users;

import java.util.List;

import com.example.javanotes.dtos.users.UserRequestDTO;
import com.example.javanotes.dtos.users.UserResponseDTO;
import com.example.javanotes.entities.users.UsersEntity;

public interface UsersServiceInterface {
    UserResponseDTO addUser(UserRequestDTO usersDTO);

    List<UsersEntity> getAllUsers();
}
