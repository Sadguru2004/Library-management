package com.sadguru.library_Management.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "Required")
    private String userName;

    @NotBlank(message = "Required")
    private String password;
}
