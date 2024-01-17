package com.easy.learn.repository;

import com.easy.learn.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback , Long> {
    Feedback findByUuid(String uuid);
}
