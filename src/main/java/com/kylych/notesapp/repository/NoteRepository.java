package com.kylych.notesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kylych.notesapp.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
