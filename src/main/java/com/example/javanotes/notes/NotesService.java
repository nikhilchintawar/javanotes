package com.example.javanotes.notes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotesService implements NotesServiceInterface {
    private NotesRepository notesRepository;


    @Autowired
    public void setNotesRepository(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public List<NotesModel> getAllNotes(){
        List<NotesModel> notes = notesRepository.findAll();
        return notes;
    }

    @Override
    public NotesModel addNote(NotesDTO notesDTO){
        NotesModel note = new NotesModel();
        note.setTitle(notesDTO.getTitle());
        note.setDescription(notesDTO.getDescription());
        return notesRepository.save(note);
    }

    @Override
    public NotesModel getNoteById(Integer id){
        Optional<NotesModel> note = notesRepository.findById(id);
        return note.orElseThrow(() -> new ResourceNotFoundException("Note not found with id " + id));
    }

    @Override
    public NotesModel updateNoteById(Integer id, NotesDTO notesDTO){
        NotesModel note = getNoteById(id);
        note.setTitle(notesDTO.getTitle());
        note.setDescription(notesDTO.getDescription());
        notesRepository.save(note);
        return note;
    }

    @Override
    public void deleteNoteById(Integer id){
        NotesModel note = getNoteById(id);
        notesRepository.delete(note);
    }

}
