package com.pseudowasabi.userservice.web;

import com.pseudowasabi.userservice.service.UsersService;
import com.pseudowasabi.userservice.web.dto.UsersSaveRequestDto;
import com.pseudowasabi.userservice.web.dto.UsersSaveResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UsersApiController {

    private final UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UsersSaveRequestDto usersSaveRequestDto) {
        Long id = usersService.createUser(usersSaveRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                UsersSaveResponseDto.builder()
                        .id(id)
                        .email(usersSaveRequestDto.getEmail())
                        .name(usersSaveRequestDto.getName())
                        .userId(usersSaveRequestDto.getUserId())
                        .build()
        );
    }
}
