package com.easy.learn.service;

import com.easy.learn.dto.LessonDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LessonService extends BaseService<LessonDTO> {
//    List<LessonDTO> findByCourse_Id(Long courseId);

List<LessonDTO> findLessonByCourseId(Long courseId);



}
