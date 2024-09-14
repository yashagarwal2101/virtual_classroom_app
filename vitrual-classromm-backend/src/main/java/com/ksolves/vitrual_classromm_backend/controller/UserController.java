package com.ksolves.vitrual_classromm_backend.controller;

import com.ksolves.vitrual_classromm_backend.dto.user.UserRequest;
import com.ksolves.vitrual_classromm_backend.dto.user.UserResponse;
import com.ksolves.vitrual_classromm_backend.dto.user.UserSignupRequest;
import com.ksolves.vitrual_classromm_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> userLogin(@Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse=userService.userLogin(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> userSignup(@Valid @RequestBody UserSignupRequest userRequest) {
        UserResponse userResponse=userService.userSignup(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
