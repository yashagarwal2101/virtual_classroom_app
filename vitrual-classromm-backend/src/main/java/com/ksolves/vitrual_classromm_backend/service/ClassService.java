package com.ksolves.vitrual_classromm_backend.service;

import com.ksolves.vitrual_classromm_backend.dto.classess.ClassRequest;
import com.ksolves.vitrual_classromm_backend.dto.classess.ClassResponse;
import com.ksolves.vitrual_classromm_backend.dto.classess.EnrollRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClassService {
    ClassResponse createClass(ClassRequest classRequest);

    String enrollClass(EnrollRequest enrollRequest);

    List<ClassResponse> fetchAllUsersClasses(Integer userId);

    List<ClassResponse> fetchAllClasses();
}
