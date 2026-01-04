package com.pseudowasabi.userservice.web.dto.request;

import com.pseudowasabi.userservice.domain.user.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class UsersSaveRequest {

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

    @NotNull(message = "Nickname cannot be null")
    @Size(min = 6, message = "Nickname should be longer than or equal to 6")
    private String nickname;

    @Builder
    public UsersSaveRequest(String email, String password, String name, String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    public Users toEntity() {
        return Users.builder()
                .userId(UUID.randomUUID().toString())
                .email(email)
                .password(password)
                .name(name)
                .nickname(nickname)
                .build();
    }
    // another way to convert class: ModelMapper
}
