package com.easy.learn.mapper;

import com.easy.learn.dto.CourseDTO;
import com.easy.learn.entity.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper extends AbstractMapper<Course, CourseDTO>{
    public CourseMapper() {
        super(Course.class, CourseDTO.class);
    }

    public void updateCourseFromDTO(CourseDTO courseDTO, Course existingCourse) {
        updateEntityFromDTO(courseDTO, existingCourse);
        // Các điều chỉnh hoặc ánh xạ đặc biệt khác (nếu cần thiết)
    }

}
