package com.pseudowasabi.userservice.domain.user;

import com.pseudowasabi.userservice.domain.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;    // encrypted
    private String name;
    private String userId;

    @Builder
    public Users(String email, String password, String name, String userId) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userId = userId;
    }

    // use JPA dirty checking
    // user_id cannot be modified
    public void update(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
