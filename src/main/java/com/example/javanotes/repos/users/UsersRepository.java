package com.example.javanotes.repos.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.javanotes.entities.users.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

    @Query("SELECT DISTINCT u FROM UsersEntity u JOIN FETCH u.notes")
    List<UsersEntity> findAllUsersWithNotes();
}
