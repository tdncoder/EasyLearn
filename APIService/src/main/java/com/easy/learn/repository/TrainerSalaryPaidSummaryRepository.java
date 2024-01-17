package com.easy.learn.repository;

import com.easy.learn.entity.TrainerSalaryPaidSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerSalaryPaidSummaryRepository extends JpaRepository<TrainerSalaryPaidSummary, Long> {
    Optional<TrainerSalaryPaidSummary> findById (Long id);
}
