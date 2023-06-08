package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class ClubDTO {
    private Long id;
    @NotEmpty(message = "Club title should not empty")
    private String title;
    @NotEmpty(message = "Club url should not empty")
    private String photoURL;
    @NotEmpty(message = "Content should not empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
