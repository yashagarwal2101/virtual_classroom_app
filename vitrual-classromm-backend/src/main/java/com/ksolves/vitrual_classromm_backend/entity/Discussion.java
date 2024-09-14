package com.ksolves.vitrual_classromm_backend.entity;

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
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer discussion_id;

    private String content;

    @ManyToOne
    private User user_id;

    @ManyToOne
    private Lecture lecture_id;
}
