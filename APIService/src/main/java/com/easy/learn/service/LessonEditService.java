package com.easy.learn.service;


import com.easy.learn.dto.LessonEditDTO;
import com.easy.learn.entity.LessonEdit;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonEditService extends BaseService<LessonEditDTO>{
    boolean delete(Long id);

    LessonEditDTO saveOrUpdate(LessonEditDTO lessonEditDTO);

    LessonEditDTO findByLessonEditId(Long id);

    List<LessonEditDTO> getAllLessonByCourseId(Long id);

    boolean deleteAllLessonByCourseId(Long id);
}
