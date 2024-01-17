package com.easy.learn.repository;

import com.easy.learn.entity.Lesson;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
//    @Query(nativeQuery = true, value = "SELECT * FROM Lesson WHERE course_id = :courseId ")
//    List<Lesson> findByCourse_Id (@Param("courseId") Long courseId);


    List<Lesson> findLessonByCourseId(Long courseId);
}
