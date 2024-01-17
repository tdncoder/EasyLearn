package com.easy.learn.service;

import com.easy.learn.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll();
    CourseDTO findById(Long id);
    CourseDTO create(CourseDTO courseDTO);
    boolean update(CourseDTO courseDTO);
    boolean delete(Long id);

}
