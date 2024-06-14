
package com.example.javanotes.repos.notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javanotes.entities.notes.NotesEntity;

/**
 *
 * @author nikhilchintawar
 */
@Repository
public interface NotesRepository extends JpaRepository<NotesEntity, Integer> {
}
