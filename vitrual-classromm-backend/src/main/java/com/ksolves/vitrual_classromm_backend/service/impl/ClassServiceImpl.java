package com.ksolves.vitrual_classromm_backend.service.impl;

import com.ksolves.vitrual_classromm_backend.dao.ClassRepository;
import com.ksolves.vitrual_classromm_backend.dao.UserRepository;
import com.ksolves.vitrual_classromm_backend.dto.classess.ClassRequest;
import com.ksolves.vitrual_classromm_backend.dto.classess.ClassResponse;
import com.ksolves.vitrual_classromm_backend.dto.classess.EnrollRequest;
import com.ksolves.vitrual_classromm_backend.entity.Class;
import com.ksolves.vitrual_classromm_backend.entity.User;
import com.ksolves.vitrual_classromm_backend.exception.UserNotFoundException;
import com.ksolves.vitrual_classromm_backend.service.ClassService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ClassServiceImpl(ClassRepository classRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.classRepository = classRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClassResponse createClass(ClassRequest classRequest) {
        Class classObj = new Class();
        classObj.setName(classRequest.getName());
        classObj.setDescription(classRequest.getDescription());
        classObj.setUsers(new ArrayList<>());
        classRepository.save(classObj);

        ClassResponse classResponse=new ClassResponse();
        classResponse.setInstructorName("anuj");
        return modelMapper.map(classObj, ClassResponse.class);
    }

    @Override
    public String enrollClass(EnrollRequest enrollRequest) {
        try{
            User user= userRepository.findById(enrollRequest.getUserId()).orElseThrow(() -> new UserNotFoundException("User not found"));
            Class classObj=classRepository.findById(enrollRequest.getClassId()).orElseThrow(() -> new RuntimeException("Class not found"));

            List<User> users=classObj.getUsers();
            users.add(user);
            classObj.setUsers(users);
            classRepository.save(classObj);
            return "Enrolled successfully";
        }
        catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<ClassResponse> fetchAllUsersClasses(Integer userId) {
        if(userId==null){
            throw new RuntimeException("User Id is required");
        }
        User user=userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<Class> userClasses=classRepository.findAllByUsers(user);
        return userClasses.stream().map(classObj -> modelMapper.map(classObj, ClassResponse.class)).toList();
    }

    @Override
    public List<ClassResponse> fetchAllClasses() {
        List<Class> classes=classRepository.findAll();
        return classes.stream().map(classObj -> modelMapper.map(classObj, ClassResponse.class)).toList();
    }


}
