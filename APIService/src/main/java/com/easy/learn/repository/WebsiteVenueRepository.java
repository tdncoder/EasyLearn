package com.easy.learn.repository;

import com.easy.learn.entity.WebsiteVenue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebsiteVenueRepository extends JpaRepository<WebsiteVenue, Long> {
    Optional<WebsiteVenue> findById (Long id);
}
