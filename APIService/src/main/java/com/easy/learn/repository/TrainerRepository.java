package com.easy.learn.repository;



import com.easy.learn.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findByUuid(String uuid);

    @Query("SELECT t FROM Trainer t LEFT JOIN TrainerSalaryPaid tsp ON t.id = tsp.trainerId AND tsp.active = true WHERE tsp.trainerId IS NULL")
    List<Trainer> findTrainersNotInSalaryPaid();

}
