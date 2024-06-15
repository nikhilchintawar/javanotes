package com.example.javanotes.dtos.notes;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotesResponseDTO {
    @NotBlank(message="Title is required")
    private String title;
    
    @Nullable
    private String description;
}
