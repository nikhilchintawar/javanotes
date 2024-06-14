package com.example.javanotes.entities.users;

import java.util.List;

import com.example.javanotes.core.enitities.BaseEntity;
import com.example.javanotes.entities.notes.NotesEntity;
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
public class UsersEntity extends BaseEntity {
    @Column(name="name", length=100)
    private String name;

    @Email(message="Please enter valid email address")
    @Column(name="email", length=255)
    private String email;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<NotesEntity> notes;

}
