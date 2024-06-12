package com.example.javanotes.notes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
    private NotesRepository notesRepository;


    @Autowired
    public void setNotesRepository(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public List<NotesModel> getAllNotes(){
        List<NotesModel> notes = notesRepository.findAll();
        return notes;
    }

}
