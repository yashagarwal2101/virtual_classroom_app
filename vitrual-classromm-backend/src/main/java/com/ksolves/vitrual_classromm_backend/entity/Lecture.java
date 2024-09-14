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
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lecture_id;
    private String title;
    private String lecture_video_url;
    private String pdf_url;

    @ManyToOne
    private Session session_id;
}
