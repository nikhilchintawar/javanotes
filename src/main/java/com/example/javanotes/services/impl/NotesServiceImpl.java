package com.example.javanotes.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javanotes.dto.notes.NotesRequestDTO;
import com.example.javanotes.dto.notes.NotesResponseDTO;
import com.example.javanotes.entities.Note;
import com.example.javanotes.entities.User;
import com.example.javanotes.exceptions.ResourceNotFoundException;
import com.example.javanotes.repositories.NotesRepository;
import com.example.javanotes.repositories.UserRepository;
import com.example.javanotes.services.NotesService;

import jakarta.persistence.EntityNotFoundException;


@Service
public class NotesServiceImpl implements NotesService {
    private NotesRepository notesRepository;
    private UserRepository usersRepository;


    @Autowired
    public void setNotesRepository(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Autowired
    public void setUsersRepository(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<NotesResponseDTO> getAllNotes(Integer user_id){
        List<Note> notes = notesRepository.findAllByUserId(user_id);
        List<NotesResponseDTO> res = notes.stream().map(note -> convertToNotesResponseDTO(note.getTitle(), note.getDescription())).collect(Collectors.toList());
        return res;
    }

    @Override
    public NotesResponseDTO addNote(NotesRequestDTO notesDTO){
        Note note = new Note();
        note.setTitle(notesDTO.getTitle());
        note.setDescription(notesDTO.getDescription());
                // Fetch the Users using the user ID from NotesDTO
        User user = usersRepository.findById(notesDTO.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + notesDTO.getUser_id()));
        note.setUser(user);
        notesRepository.save(note);
        return convertToNotesResponseDTO(note.getTitle(), note.getDescription());
    }

    @Override
    public NotesResponseDTO getNoteById(Integer id){
        Note note = getNotesEntityById(id);
        return convertToNotesResponseDTO(note.getTitle(), note.getDescription());
    }

    @Override
    public NotesResponseDTO updateNoteById(Integer id, NotesRequestDTO notesDTO){
        Note note = getNotesEntityById(id);
        note.setTitle(notesDTO.getTitle());
        note.setDescription(notesDTO.getDescription());
        notesRepository.save(note);
        return convertToNotesResponseDTO(note.getTitle(), note.getDescription());
    }

    @Override
    public void deleteNoteById(Integer id){
        Note note = getNotesEntityById(id);
        notesRepository.delete(note);
    }

    public NotesResponseDTO convertToNotesResponseDTO(String title, String description){
        NotesResponseDTO note = new NotesResponseDTO();
        note.setTitle(title);
        note.setDescription(description);
        return note;
    }

    public Note getNotesEntityById(Integer id){
        Optional<Note> note = notesRepository.findById(id);
        if(note.isPresent()){
            return note.get();
        } else {
            throw new ResourceNotFoundException("Note not found with id " + id);
        }
    }

}
