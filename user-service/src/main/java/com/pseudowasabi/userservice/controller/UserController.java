package com.pseudowasabi.userservice.controller;

import com.pseudowasabi.userservice.Greeting;
import com.pseudowasabi.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final Environment env;
    private final Greeting greeting;
    private final UserService userService;

    @GetMapping("/health-check")
    public String status() {
        return String.format("Hello %s, %s!", env.getProperty("local.server.port"), env.getProperty("server.port"));
    }

    @GetMapping("/greeting")
    public String greeting() {
        return greeting.getGreetingMessage();
    }

}
