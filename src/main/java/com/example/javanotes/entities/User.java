package com.example.javanotes.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User extends Base {
    @Column(name="name", length=100)
    private String name;

    @Email(message="Please enter valid email address")
    @Column(name="email", length=255)
    private String email;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<Note> notes;

}
