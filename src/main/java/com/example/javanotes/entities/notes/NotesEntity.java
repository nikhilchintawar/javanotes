package com.example.javanotes.entities.notes;

import com.example.javanotes.core.enitities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="notes")
@Getter
@Setter
public class NotesEntity extends BaseEntity {
    @Size(max = 100, message = "Title cannot be longer than 100 characters")
    private String title;

    @Size(max = 250, message = "Title cannot be longer than 100 characters")
    @Column(name="description", nullable=true)
    private String description;
}
