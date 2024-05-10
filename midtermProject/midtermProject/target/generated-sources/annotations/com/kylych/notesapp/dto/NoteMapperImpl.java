package com.kylych.notesapp.dto;

import com.kylych.notesapp.entity.Note;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-10T04:03:15+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class NoteMapperImpl implements NoteMapper {

    @Override
    public Note noteDTOToNote(NoteDTO noteDTO) {
        if ( noteDTO == null ) {
            return null;
        }

        Note note = new Note();

        note.setTitle( noteDTO.getTitle() );
        note.setContent( noteDTO.getContent() );

        return note;
    }

    @Override
    public NoteDTO noteToNoteDTO(Note note) {
        if ( note == null ) {
            return null;
        }

        NoteDTO noteDTO = new NoteDTO();

        noteDTO.setTitle( note.getTitle() );
        noteDTO.setContent( note.getContent() );

        return noteDTO;
    }
}
