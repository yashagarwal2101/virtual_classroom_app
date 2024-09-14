package com.ksolves.vitrual_classromm_backend.entity;

import com.ksolves.vitrual_classromm_backend.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType role;
}
