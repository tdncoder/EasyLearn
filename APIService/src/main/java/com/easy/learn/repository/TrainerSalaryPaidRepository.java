package com.easy.learn.repository;

import com.easy.learn.entity.TrainerSalaryPaid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrainerSalaryPaidRepository extends JpaRepository<TrainerSalaryPaid, Long> {
    @Query("SELECT t FROM TrainerSalaryPaid t WHERE t.id = ?1 AND t.active = 1")
    Optional<TrainerSalaryPaid> findActiveById(Long id);

    @Query("SELECT t FROM TrainerSalaryPaid t WHERE t.active = 1")
    List<TrainerSalaryPaid> findByActiveTrue();

}
