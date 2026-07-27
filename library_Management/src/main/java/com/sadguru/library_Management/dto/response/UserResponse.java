package com.sadguru.library_Management.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long id;

    private String userName;

    private String email;

    private String fullName;

    private LocalDateTime created_at;
}
