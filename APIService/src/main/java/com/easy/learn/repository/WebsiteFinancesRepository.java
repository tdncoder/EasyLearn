package com.easy.learn.repository;

import com.easy.learn.entity.WebsiteFinances;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebsiteFinancesRepository extends JpaRepository<WebsiteFinances, Long> {
    Optional<WebsiteFinances> findById (Long id);
}
