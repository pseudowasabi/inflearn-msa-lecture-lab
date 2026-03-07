package com.pseudowasabi.userservice.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email should be longer than or equal to 2")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password should be longer than or equal to 8")
    private String password;
}
