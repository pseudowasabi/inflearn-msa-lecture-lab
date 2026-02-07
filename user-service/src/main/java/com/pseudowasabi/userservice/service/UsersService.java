package com.pseudowasabi.userservice.service;

import com.pseudowasabi.userservice.domain.user.Users;
import com.pseudowasabi.userservice.domain.user.UsersRepository;
import com.pseudowasabi.userservice.web.dto.request.UsersSaveRequest;
import com.pseudowasabi.userservice.web.dto.response.OrdersResponse;
import com.pseudowasabi.userservice.web.dto.response.UsersResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String createUser(UsersSaveRequest usersSaveRequest) {
        Users users = usersSaveRequest.toEntity();
        users.update(
                users.getEmail(),
                passwordEncoder.encode(users.getPassword()),
                users.getName()
        );
        return usersRepository.save(users).getUserId();
    }

    public UsersResponse getUsersResponse(String userId) {
        Users users = usersRepository.findByUserId(userId);

        if (users == null) {
            throw new UsernameNotFoundException("USER NOT FOUND");
        }

        UsersResponse usersResponse = UsersResponse.builder()
                .userId(userId)
                .email(users.getEmail())
                .name(users.getName())
                .nickname(users.getNickname())
                .build();

        List<OrdersResponse> orders = new ArrayList<>();
        usersResponse.setOrders(orders);

        return usersResponse;
    }

    public Iterable<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
