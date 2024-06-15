package com.example.javanotes.controllers.notes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.javanotes.dtos.notes.NotesRequestDTO;
import com.example.javanotes.dtos.notes.NotesResponseDTO;
import com.example.javanotes.entities.notes.NotesEntity;
import com.example.javanotes.exceptions.ResourceNotFoundException;
import com.example.javanotes.services.notes.NotesService;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/api")
public class NotesController {
    public NotesService notesService;


    @Autowired
    public void setNotesService(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notes")
    public ResponseEntity<List<NotesResponseDTO>> getAllNotes(@RequestParam Integer user_id) {
        List<NotesResponseDTO> notes = notesService.getAllNotes(user_id);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping("/notes")
    public ResponseEntity<NotesResponseDTO> addNote(@Valid @RequestBody NotesRequestDTO notesDTO) {
        NotesResponseDTO note = notesService.addNote(notesDTO);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<NotesEntity> getNote(@PathVariable Integer id) {
        NotesEntity note = notesService.getNoteById(id);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }
    

    @PutMapping("/notes/{id}")
    public ResponseEntity<NotesResponseDTO> updateNote(@Valid @PathVariable Integer id, @RequestBody @Valid NotesRequestDTO notesDTO) {
        NotesResponseDTO note = notesService.updateNoteById(id, notesDTO);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Integer id) {
        notesService.deleteNoteById(id);
        return new ResponseEntity<>("Note deleted successfully!!!", HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
