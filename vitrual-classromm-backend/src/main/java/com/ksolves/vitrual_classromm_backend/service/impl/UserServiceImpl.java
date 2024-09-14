package com.ksolves.vitrual_classromm_backend.service.impl;

import com.ksolves.vitrual_classromm_backend.dao.UserRepository;
import com.ksolves.vitrual_classromm_backend.dto.user.UserRequest;
import com.ksolves.vitrual_classromm_backend.dto.user.UserResponse;
import com.ksolves.vitrual_classromm_backend.dto.user.UserSignupRequest;
import com.ksolves.vitrual_classromm_backend.entity.User;
import com.ksolves.vitrual_classromm_backend.enums.UserType;
import com.ksolves.vitrual_classromm_backend.exception.InvalidPasswordException;
import com.ksolves.vitrual_classromm_backend.exception.UserAlreadyExistsException;
import com.ksolves.vitrual_classromm_backend.exception.UserNotFoundException;
import com.ksolves.vitrual_classromm_backend.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse userLogin(UserRequest userRequest) {
        User user=userRepository.findByEmail(userRequest.getEmail()).orElseThrow(() -> new UserNotFoundException("User not found"));
        if(user.getPassword().equals(userRequest.getPassword()))
            return new UserResponse(user.getName(),user.getEmail(),user.getRole());
        else
            throw new InvalidPasswordException("invalid password");
    }

    @Override
    public UserResponse userSignup(UserSignupRequest userRequest) {
        Optional<User> userOptional = userRepository.findByEmail(userRequest.getEmail());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException(userRequest.getEmail());
        }
        log.info("trying to save user: {}", userRequest);
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(UserType.Student);
        log.info("user saved: {}", user);
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser.getName(),savedUser.getEmail(),savedUser.getRole());
    }

    @PostConstruct
    public void init(){
        User user = new User();
        user.setUser_id(1);
        user.setName("anuj");
        user.setEmail("anuj@gmail.com");
        user.setPassword("anuj@123");
        user.setRole(UserType.Instructor);
        userRepository.save(user);
    }

}



