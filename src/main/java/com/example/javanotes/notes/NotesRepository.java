
package com.example.javanotes.notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nikhilchintawar
 */
@Repository
public interface NotesRepository extends JpaRepository<NotesModel, Integer> {

}
