package com.kylych.notesapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NoteDTO {

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
