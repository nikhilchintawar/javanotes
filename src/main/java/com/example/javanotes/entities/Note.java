package com.example.javanotes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="notes")
@Getter
@Setter
public class Note extends Base {
    @Size(max = 100, message = "Title cannot be longer than 100 characters")
    private String title;

    @Size(max = 250, message = "Title cannot be longer than 100 characters")
    @Column(name="description", nullable=true)
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")
    @NotNull(message = "User must be specified")
    @JsonIgnoreProperties("notes")
    private User user;
}
