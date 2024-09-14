package com.ksolves.vitrual_classromm_backend.dto.classess;

import com.ksolves.vitrual_classromm_backend.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClassResponse {
    private Integer class_id;
    private String name;
    private String description;
    private String instructorName;
    private ArrayList<String> students=new ArrayList<>();
}
