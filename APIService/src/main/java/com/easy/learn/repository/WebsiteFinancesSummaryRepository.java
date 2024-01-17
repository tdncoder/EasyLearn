package com.easy.learn.repository;

import com.easy.learn.entity.WebsiteFinancesSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebsiteFinancesSummaryRepository extends JpaRepository<WebsiteFinancesSummary, Long> {
    Optional<WebsiteFinancesSummary> findById (Long id);
}
