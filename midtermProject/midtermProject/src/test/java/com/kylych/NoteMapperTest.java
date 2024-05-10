package com.kylych;

import com.kylych.notesapp.dto.NoteDTO;
import com.kylych.notesapp.dto.NoteMapper;
import com.kylych.notesapp.entity.Note;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteMapperTest {

    private final NoteMapper noteMapper = NoteMapper.INSTANCE;

    @Test
    public void testNoteDTOToNote() {
        // Arrange
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setTitle("Test Title");
        noteDTO.setContent("Test Content");

        // Act
        Note note = noteMapper.noteDTOToNote(noteDTO);

        // Assert
        assertThat(note).isNotNull();
        assertThat(note.getTitle()).isEqualTo(noteDTO.getTitle());
        assertThat(note.getContent()).isEqualTo(noteDTO.getContent());
    }

    @Test
    public void testNoteToNoteDTO() {
        // Arrange
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Test Title");
        note.setContent("Test Content");

        // Act
        NoteDTO noteDTO = noteMapper.noteToNoteDTO(note);

        // Assert
        assertThat(noteDTO).isNotNull();
        assertThat(noteDTO.getTitle()).isEqualTo(note.getTitle());
        assertThat(noteDTO.getContent()).isEqualTo(note.getContent());
    }
}
