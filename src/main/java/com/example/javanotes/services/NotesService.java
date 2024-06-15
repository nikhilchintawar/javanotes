/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.javanotes.services;

import java.util.List;

import com.example.javanotes.dto.notes.NotesRequestDTO;
import com.example.javanotes.dto.notes.NotesResponseDTO;

/**
 *
 * @author nikhilchintawar
 */
public interface NotesService {
    NotesResponseDTO addNote(NotesRequestDTO notesDTO);
    List<NotesResponseDTO> getAllNotes(Integer user_id);
    NotesResponseDTO getNoteById(Integer id);
    NotesResponseDTO updateNoteById(Integer id, NotesRequestDTO notesDTO);
    void deleteNoteById(Integer id);
}
