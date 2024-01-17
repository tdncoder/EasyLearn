package com.easy.learn.repository;

import com.easy.learn.entity.FinalSalarySummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FinalSalarySummaryRepository extends JpaRepository<FinalSalarySummary, Long> {
    Optional<FinalSalarySummary> findById (Long id);
}
