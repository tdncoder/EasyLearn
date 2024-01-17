package com.easy.learn.mapper;

import com.easy.learn.dto.CourseDTO;
import com.easy.learn.dto.LessonDTO;
import com.easy.learn.entity.Course;
import com.easy.learn.entity.Lesson;
import org.springframework.stereotype.Service;

@Service
public class LessonMapper extends AbstractMapper<Lesson, LessonDTO>{
    public LessonMapper() {
        super(Lesson.class, LessonDTO.class);
    }
}
