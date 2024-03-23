package com.kylych;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kylych.notesapp.entity.Note;
import com.kylych.notesapp.repository.NoteRepository;
import com.kylych.notesapp.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE) // Используем реальную базу данных MySQL
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void testCreateNote() throws Exception {
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/notes")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(note)));

        resultActions.andExpect(status().isOk());
    }

    @Test
    public void testGetNoteById() throws Exception {
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");

        note = noteRepository.save(note);

        Long noteId = note.getId();

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/notes/{id}", noteId));

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(noteId))
                .andExpect(jsonPath("$.title").value("Test Title"))
                .andExpect(jsonPath("$.content").value("Test Content"));
    }
}

