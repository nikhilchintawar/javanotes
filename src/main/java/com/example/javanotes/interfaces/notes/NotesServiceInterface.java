/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.javanotes.interfaces.notes;

import java.util.List;

import com.example.javanotes.dtos.notes.NotesRequestDTO;
import com.example.javanotes.dtos.notes.NotesResponseDTO;
import com.example.javanotes.entities.notes.NotesEntity;

/**
 *
 * @author nikhilchintawar
 */
public interface NotesServiceInterface {
    NotesResponseDTO addNote(NotesRequestDTO notesDTO);
    List<NotesResponseDTO> getAllNotes(Integer user_id);
    NotesEntity getNoteById(Integer id);
    NotesResponseDTO updateNoteById(Integer id, NotesRequestDTO notesDTO);
    void deleteNoteById(Integer id);
}
