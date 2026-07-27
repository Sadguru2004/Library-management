package com.sadguru.library_Management.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {

    private Long id;

    private String BookName;

    private String author;

    private LocalDateTime created_at;
}
