/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.javanotes.notes;

import java.util.List;

/**
 *
 * @author nikhilchintawar
 */
public interface NotesServiceInterface {
    NotesModel addNote(NotesDTO notesDTO);
    List<NotesModel> getAllNotes();
    NotesModel getNoteById(Integer id);
    NotesModel updateNoteById(Integer id, NotesDTO notesDTO);
    void deleteNoteById(Integer id);
}
