/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.javanotes.interfaces.notes;

import java.util.List;

import com.example.javanotes.dtos.notes.NotesDTO;
import com.example.javanotes.entities.notes.NotesEntity;

/**
 *
 * @author nikhilchintawar
 */
public interface NotesServiceInterface {
    NotesEntity addNote(NotesDTO notesDTO);
    List<NotesEntity> getAllNotes();
    NotesEntity getNoteById(Integer id);
    NotesEntity updateNoteById(Integer id, NotesDTO notesDTO);
    void deleteNoteById(Integer id);
}
