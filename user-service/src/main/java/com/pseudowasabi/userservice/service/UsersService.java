package com.pseudowasabi.userservice.service;

import com.pseudowasabi.userservice.domain.user.Users;
import com.pseudowasabi.userservice.domain.user.UsersRepository;
import com.pseudowasabi.userservice.web.dto.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long createUser(UsersSaveRequestDto usersSaveRequestDto) {
        Users users = usersSaveRequestDto.toEntity();
        users.update(
                users.getEmail(),
                passwordEncoder.encode(users.getPassword()),
                users.getName()
        );
        return usersRepository.save(users).getId();
    }
}
