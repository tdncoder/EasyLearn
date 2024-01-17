package com.easy.learn.repository;

import com.easy.learn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUuid(String uuid);
}
