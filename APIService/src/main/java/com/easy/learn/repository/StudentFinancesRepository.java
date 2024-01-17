package com.easy.learn.repository;

import com.easy.learn.entity.StudentFinances;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentFinancesRepository extends JpaRepository<StudentFinances, Long> {
    Optional<StudentFinances> findById (Long id);
}
