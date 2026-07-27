package com.sadguru.library_Management.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRequest {

    @NotBlank(message = "Required")
    private String userName;

    @Email
    private String email;

    @NotBlank(message = "Required")
    private String fullName;

    @NotBlank(message = "Required")
    private String password;
}
