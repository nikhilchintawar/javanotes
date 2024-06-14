package com.example.javanotes.services.notes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javanotes.dtos.notes.NotesDTO;
import com.example.javanotes.entities.notes.NotesEntity;
import com.example.javanotes.entities.users.UsersEntity;
import com.example.javanotes.exceptions.ResourceNotFoundException;
import com.example.javanotes.interfaces.notes.NotesServiceInterface;
import com.example.javanotes.repos.notes.NotesRepository;
import com.example.javanotes.repos.users.UsersRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class NotesService implements NotesServiceInterface {
    private NotesRepository notesRepository;
    private UsersRepository usersRepository;


    @Autowired
    public void setNotesRepository(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<NotesEntity> getAllNotes(){
        List<NotesEntity> notes = notesRepository.findAll();
        return notes;
    }

    @Override
    public NotesEntity addNote(NotesDTO notesDTO){
        NotesEntity note = new NotesEntity();
        note.setTitle(notesDTO.getTitle());
        note.setDescription(notesDTO.getDescription());
                // Fetch the UsersEntity using the user ID from NotesDTO
        UsersEntity user = usersRepository.findById(notesDTO.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + notesDTO.getUser_id()));
        note.setUser(user);
        return notesRepository.save(note);
    }

    @Override
    public NotesEntity getNoteById(Integer id){
        Optional<NotesEntity> note = notesRepository.findById(id);
        return note.orElseThrow(() -> new ResourceNotFoundException("Note not found with id " + id));
    }

    @Override
    public NotesEntity updateNoteById(Integer id, NotesDTO notesDTO){
        NotesEntity note = getNoteById(id);
        note.setTitle(notesDTO.getTitle());
        note.setDescription(notesDTO.getDescription());
        notesRepository.save(note);
        return note;
    }

    @Override
    public void deleteNoteById(Integer id){
        NotesEntity note = getNoteById(id);
        notesRepository.delete(note);
    }

}
