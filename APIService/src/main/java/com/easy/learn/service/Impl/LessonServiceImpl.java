package com.easy.learn.service.Impl;

import com.easy.learn.dto.LessonDTO;
import com.easy.learn.entity.Lesson;
import com.easy.learn.mapper.LessonMapper;
import com.easy.learn.repository.LessonRepository;
import com.easy.learn.service.LessonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class LessonServiceImpl implements LessonService {
    @Autowired
    LessonRepository repo;
    @Autowired
    LessonMapper mapper;

    @Override
    public LessonDTO create(LessonDTO lessonDTO) {
        return null;
    }

    @Override
    public boolean update(LessonDTO lessonDTO) {
        return false;
    }

    @Override
    public List<LessonDTO> findAll() {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<LessonDTO> findLessonByCourseId (Long id) {
        List<Lesson> lessonList = repo.findLessonByCourseId(id);
        return lessonList == null ? new ArrayList<>()
                : lessonList.stream().map(entity -> mapper.convertEntityToDTO(entity))
                .collect(Collectors.toList());
    }


}
