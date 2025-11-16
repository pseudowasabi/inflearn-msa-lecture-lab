package com.pseudowasabi.userservice.web.dto;

import com.pseudowasabi.userservice.domain.user.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {

    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email should be longer than or equal to 2")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password should be longer than or equal to 8")
    private String password;

    @NotNull(message = "Name cannot be null")
    @Size(min =  2, message = "Name should be longer than or equal to 2")
    private String name;

    @NotNull(message = "User ID cannot be null")
    @Size(min = 6, message = "User ID should be longer than or equal to 6")
    private String userId;

    @Builder
    public UsersSaveRequestDto(String email, String password, String name, String userId) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userId = userId;
    }

    public Users toEntity() {
        return Users.builder()
                .email(email)
                .password(password)
                .name(name)
                .userId(userId)
                .build();
    }
    // another way to convert class: ModelMapper
}
