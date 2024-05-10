package com.kylych.notesapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kylych.notesapp.exception.ResourceNotFoundException;
import com.kylych.notesapp.entity.Note;
import com.kylych.notesapp.service.NoteService;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping("/notes")
    public Note createNote(@Validated @RequestBody Note note) {
        return noteService.createNote(note);
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteService.getNoteById(noteId);
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId, @Validated @RequestBody Note noteDetails) {
        return noteService.updateNote(noteId, noteDetails);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        noteService.deleteNote(noteId);
        return ResponseEntity.ok().build();
    }
}
