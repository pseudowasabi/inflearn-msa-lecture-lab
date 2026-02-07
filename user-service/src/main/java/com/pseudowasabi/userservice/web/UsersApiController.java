package com.pseudowasabi.userservice.web;

import com.pseudowasabi.userservice.domain.user.Users;
import com.pseudowasabi.userservice.service.UsersService;
import com.pseudowasabi.userservice.web.dto.request.UsersSaveRequest;
import com.pseudowasabi.userservice.web.dto.response.UsersResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UsersApiController {

    private final UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UsersSaveRequest usersSaveRequest) {
        String userId = usersService.createUser(usersSaveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                UsersResponse.builder()
                        .userId(userId)
                        .email(usersSaveRequest.getEmail())
                        .name(usersSaveRequest.getName())
                        .nickname(usersSaveRequest.getNickname())
                        .build()
        );
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        Iterable<Users> usersIterable = usersService.getAllUsers();

        List<UsersResponse> usersResponseList = new ArrayList<>();
        usersIterable.forEach(users -> usersResponseList.add(
                UsersResponse.builder()
                        .userId(users.getUserId())
                        .email(users.getEmail())
                        .name(users.getName())
                        .nickname(users.getNickname())
                        .build()
        ));

        return ResponseEntity.status(HttpStatus.OK).body(usersResponseList);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUser(@PathVariable("userId") String userId) {
        UsersResponse usersResponse = usersService.getUsersResponse(userId);
        return ResponseEntity.status(HttpStatus.OK).body(usersResponse);
    }
}
