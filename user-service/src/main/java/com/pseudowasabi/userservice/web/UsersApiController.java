package com.pseudowasabi.userservice.web;

import com.pseudowasabi.userservice.service.UsersService;
import com.pseudowasabi.userservice.web.dto.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class UsersApiController {

    private final UsersService usersService;

    @PostMapping("/users")
    public Long createUser(@RequestBody UsersSaveRequestDto usersSaveRequestDto) {
        return usersService.createUser(usersSaveRequestDto);
    }
}
