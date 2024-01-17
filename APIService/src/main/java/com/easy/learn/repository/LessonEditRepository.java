package com.easy.learn.repository;

import com.easy.learn.entity.CourseEdit;
import com.easy.learn.entity.LessonEdit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface LessonEditRepository extends JpaRepository<LessonEdit, Long> {

    Optional<LessonEdit> findById(Long id);

    @Query("SELECT l FROM LessonEdit l WHERE l.courseEditId = ?1")
    List<LessonEdit> getAllLessonByCourseId(Long id);

//    @Transactional
//    @Modifying
//    boolean deleteAllLessonByCourseId(Long id);

}
