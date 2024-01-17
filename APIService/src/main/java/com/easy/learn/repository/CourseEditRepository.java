package com.easy.learn.repository;

import com.easy.learn.entity.CourseEdit;
import com.easy.learn.entity.TrainerSalaryPaid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseEditRepository extends JpaRepository<CourseEdit,Long> {
    Optional<CourseEdit> findById (Long id);
}
