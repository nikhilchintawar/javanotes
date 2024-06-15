
package com.example.javanotes.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javanotes.entities.Note;

/**
 *
 * @author nikhilchintawar
 */
@Repository
public interface NotesRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllByUserId(Integer user_id);
}
