package com.easy.learn.repository;

import com.easy.learn.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query("SELECT m from Manager m WHERE m.username=?1 AND m.password=?2")
    Manager findByUserNameAndPassword(String username, String password);
    Manager findByUuid(String uuid);
    Manager findByUsername(String username);

}
