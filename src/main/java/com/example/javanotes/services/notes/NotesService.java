package com.example.javanotes.services.notes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javanotes.dtos.notes.NotesRequestDTO;
import com.example.javanotes.dtos.notes.NotesResponseDTO;
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
    public List<NotesResponseDTO> getAllNotes(Integer user_id){
        List<NotesEntity> notes = notesRepository.findAllByUserId(user_id);
        List<NotesResponseDTO> res = notes.stream().map(note -> convertToNotesResponseDTO(note.getTitle(), note.getDescription())).collect(Collectors.toList());
        return res;
    }

    @Override
    public NotesResponseDTO addNote(NotesRequestDTO notesDTO){
        NotesEntity note = new NotesEntity();
        note.setTitle(notesDTO.getTitle());
        note.setDescription(notesDTO.getDescription());
                // Fetch the UsersEntity using the user ID from NotesDTO
        UsersEntity user = usersRepository.findById(notesDTO.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + notesDTO.getUser_id()));
        note.setUser(user);
        notesRepository.save(note);
        return convertToNotesResponseDTO(note.getTitle(), note.getDescription());
    }

    @Override
    public NotesEntity getNoteById(Integer id){
        Optional<NotesEntity> note = notesRepository.findById(id);
        return note.orElseThrow(() -> new ResourceNotFoundException("Note not found with id " + id));
    }

    @Override
    public NotesResponseDTO updateNoteById(Integer id, NotesRequestDTO notesDTO){
        NotesEntity note = getNoteById(id);
        note.setTitle(notesDTO.getTitle());
        note.setDescription(notesDTO.getDescription());
        notesRepository.save(note);
        return convertToNotesResponseDTO(note.getTitle(), note.getDescription());
    }

    @Override
    public void deleteNoteById(Integer id){
        NotesEntity note = getNoteById(id);
        notesRepository.delete(note);
    }

    public NotesResponseDTO convertToNotesResponseDTO(String title, String description){
        NotesResponseDTO note = new NotesResponseDTO();
        note.setTitle(title);
        note.setDescription(description);
        return note;
    }

}
