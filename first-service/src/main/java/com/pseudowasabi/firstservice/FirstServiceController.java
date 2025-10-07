package com.pseudowasabi.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/first-service")
public class FirstServiceController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to first-service.";
    }

    @GetMapping("message")
    public String message(@RequestHeader("f-request") String header) {
        log.info("header={}", header);
        return "Welcome to first-service with Request header: " + header;
    }
}
