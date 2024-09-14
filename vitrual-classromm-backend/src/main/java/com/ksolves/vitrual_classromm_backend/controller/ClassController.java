package com.ksolves.vitrual_classromm_backend.controller;

import com.ksolves.vitrual_classromm_backend.dto.classess.ClassRequest;
import com.ksolves.vitrual_classromm_backend.dto.classess.ClassResponse;
import com.ksolves.vitrual_classromm_backend.dto.classess.EnrollRequest;
import com.ksolves.vitrual_classromm_backend.service.ClassService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClassResponse> createClass(@Valid @RequestBody ClassRequest classRequest) {
        log.info("Request to create class: {}", classRequest);
        return ResponseEntity.status(201).body(classService.createClass(classRequest));
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollClass(@Valid @RequestBody EnrollRequest enrollRequest ) {
        log.info("Request to enroll class: {}", enrollRequest);
        return ResponseEntity.status(200).body(classService.enrollClass(enrollRequest));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ClassResponse>> fetchAllUsersClasses(@PathVariable Integer userId) {
        log.info("Request to fetch all user classes");
        return ResponseEntity.status(200).body(classService.fetchAllUsersClasses(userId));
    }

    @GetMapping
    public ResponseEntity<List<ClassResponse>> fetchAllClasses() {
        log.info("Request to fetch all classes");
        return ResponseEntity.status(200).body(classService.fetchAllClasses());
    }

}
