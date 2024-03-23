package com.kylych;

import com.kylych.notesapp.controller.NoteController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NoteController.class)
public class ExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testResourceNotFoundExceptionHandler() throws Exception {
        mockMvc.perform(get("/api/notes/100")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}


