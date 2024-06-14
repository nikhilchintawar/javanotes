package com.example.javanotes.dtos.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @Email(message = "Please enter a valid email address")
    @NotBlank(message = "Email is mandatory")
    private String email;
}

