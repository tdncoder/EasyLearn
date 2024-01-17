package com.easy.learn.service.Impl;

import com.easy.learn.dto.CourseDTO;
import com.easy.learn.entity.Course;
import com.easy.learn.entity.TrainerSalaryPaid;
import com.easy.learn.mapper.CourseMapper;
import com.easy.learn.repository.CourseRepository;
import com.easy.learn.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        return courseOptional.map(courseMapper::convertEntityToDTO).orElse(null);
    }

    @Override
    public CourseDTO create(CourseDTO courseDTO) {
        Course course = courseMapper.convertDTOToEntity(courseDTO);
        Course createdCourse = courseRepository.save(course);
        return courseMapper.convertEntityToDTO(createdCourse);
    }

    @Override
    public boolean update(CourseDTO courseDTO) {
        try {
            Course course = courseMapper.convertDTOToEntity(courseDTO);
            courseMapper.convertEntityToDTO(courseRepository.saveAndFlush(course));
            return true;
        } catch (Exception e) {
            log.error("Error when updating:", e);
            return false;
        }
    }
    @Override
    public boolean delete(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
