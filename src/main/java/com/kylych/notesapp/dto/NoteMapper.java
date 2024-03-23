package com.kylych.notesapp.dto;


import com.kylych.notesapp.dto.NoteDTO;
import com.kylych.notesapp.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoteMapper {

    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

    @Mapping(target = "id", ignore = true)
    Note noteDTOToNote(NoteDTO noteDTO);

    NoteDTO noteToNoteDTO(Note note);
}