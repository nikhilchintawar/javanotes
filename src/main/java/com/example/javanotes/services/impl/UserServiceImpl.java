package com.example.javanotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javanotes.dto.user.UserRequestDTO;
import com.example.javanotes.dto.user.UserResponseDTO;
import com.example.javanotes.entities.User;
import com.example.javanotes.repositories.UserRepository;
import com.example.javanotes.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository usersRepository;

    @Autowired
    public void setUsersRepository(UserRepository usersRepository){
        this.usersRepository = usersRepository;
    }


    @Override
    public UserResponseDTO addUser(UserRequestDTO usersDTO) {
        User user = usersRepository.save(DtoToUserEntity(usersDTO));
        return UserEntityToResponseDto(user);
    }

    @Override
    public List<User> getAllUsers(){
        List<User> users = usersRepository.findByNotesIsNotNull();
        return users;
    }


    public User DtoToUserEntity(UserRequestDTO userDto) {
		User user= new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		return user;
	}

	public UserResponseDTO UserEntityToResponseDto(User user) {
		UserResponseDTO userDto= new UserResponseDTO();
        userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}
}
