package com.example.javanotes.notes;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

/**
 *
 * @author nikhilchintawar
 */
public class NotesDTO {
    @Size(max = 100, message = "Title cannot be longer than 100 characters")
    private String title;

    @Size(max = 250, message = "Title cannot be longer than 100 characters")
    @Column(name="description", nullable=true)
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "title:" + title;
    }
    

}
