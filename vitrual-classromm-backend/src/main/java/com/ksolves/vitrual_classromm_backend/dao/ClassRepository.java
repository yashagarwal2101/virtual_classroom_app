package com.ksolves.vitrual_classromm_backend.dao;

import com.ksolves.vitrual_classromm_backend.entity.Class;
import com.ksolves.vitrual_classromm_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {
    List<Class> findAllByUsers(User user);
}
