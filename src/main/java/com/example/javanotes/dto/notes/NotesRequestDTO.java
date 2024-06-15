package com.example.javanotes.dto.notes;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nikhilchintawar
 */
@Getter
@Setter
public class NotesRequestDTO {
    @NotBlank(message="Title is required")
    private String title;
    
    @Nullable
    private String description;

    @NotNull(message="User id is required")
    private Integer user_id;
}
