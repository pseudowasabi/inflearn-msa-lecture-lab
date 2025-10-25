package com.pseudowasabi.userservice.service;

import com.pseudowasabi.userservice.domain.user.UsersRepository;
import com.pseudowasabi.userservice.web.dto.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public Long createUser(UsersSaveRequestDto usersSaveRequestDto) {
        return usersRepository.save(usersSaveRequestDto.toEntity()).getId();
    }
}
