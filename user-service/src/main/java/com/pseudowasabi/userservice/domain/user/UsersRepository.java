package com.pseudowasabi.userservice.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserId(String userId);
}
