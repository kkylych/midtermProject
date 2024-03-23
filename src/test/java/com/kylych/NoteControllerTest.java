package com.kylych;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kylych.notesapp.controller.NoteController;
import com.kylych.notesapp.entity.Note;
import com.kylych.notesapp.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class NoteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private NoteService noteService;

    @InjectMocks
    private NoteController noteController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
    }

    @Test
    public void testGetAllNotes() throws Exception {
        // Given
        List<Note> someListOfNotes = noteService.getAllNotes();
        when(noteService.getAllNotes()).thenReturn(someListOfNotes);

        // When and Then
        mockMvc.perform(get("/api/notes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Test Note"))
                .andExpect(jsonPath("$[0].content").value("Test Content"));
    }

    @Test
    public void testCreateNote() throws Exception {
        // Given
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");
        String noteJson = new ObjectMapper().writeValueAsString(note);
        when(noteService.createNote(any(Note.class))).thenReturn(note);

        // When and Then
        mockMvc.perform(post("/api/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(noteJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.content").value("Test Content"));
    }
}
