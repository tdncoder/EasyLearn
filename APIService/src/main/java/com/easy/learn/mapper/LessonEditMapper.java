package com.easy.learn.mapper;

import com.easy.learn.dto.LessonEditDTO;
import com.easy.learn.entity.LessonEdit;
import org.springframework.stereotype.Service;

@Service
public class LessonEditMapper extends AbstractMapper<LessonEdit, LessonEditDTO>{
    public LessonEditMapper(){
        super(LessonEdit.class,LessonEditDTO.class);
    }
}
