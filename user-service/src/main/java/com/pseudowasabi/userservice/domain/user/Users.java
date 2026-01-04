package com.pseudowasabi.userservice.domain.user;

import com.pseudowasabi.userservice.domain.BaseTimeEntity;
import jakarta.persistence.*;
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

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    // encrypted password
    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, unique = true)
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
