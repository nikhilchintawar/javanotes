package com.example.javanotes.services.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javanotes.dtos.users.UserRequestDTO;
import com.example.javanotes.dtos.users.UserResponseDTO;
import com.example.javanotes.entities.users.UsersEntity;
import com.example.javanotes.interfaces.users.UsersServiceInterface;
import com.example.javanotes.repos.users.UsersRepository;

@Service
public class UsersService implements UsersServiceInterface {
    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }


    @Override
    public UserResponseDTO addUser(UserRequestDTO usersDTO) {
        UsersEntity user = usersRepository.save(DtoToUserEntity(usersDTO));
        return UserEntityToResponseDto(user);
    }

    @Override
    public List<UsersEntity> getAllUsers(){
        List<UsersEntity> users = usersRepository.findAllUsersWithNotes();
        return users;
    }


    public UsersEntity DtoToUserEntity(UserRequestDTO userDto) {
		UsersEntity user= new UsersEntity();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		return user;
	}

	public UserResponseDTO UserEntityToResponseDto(UsersEntity user) {
		UserResponseDTO userDto= new UserResponseDTO();
        userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}
}
