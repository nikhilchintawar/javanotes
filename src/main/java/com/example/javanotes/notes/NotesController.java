package com.example.javanotes.notes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class NotesController {
    public NotesService notesService;


    @Autowired
    public void setNotesService(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notes")
    public ResponseEntity<List<NotesModel>> getAllNotes() {
        List<NotesModel> notes = notesService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
    
}
