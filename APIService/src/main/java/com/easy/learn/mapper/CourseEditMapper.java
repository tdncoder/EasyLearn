package com.easy.learn.mapper;

import com.easy.learn.dto.CourseEditDTO;
import com.easy.learn.dto.TrainerSalaryPaidSummaryDTO;
import com.easy.learn.entity.CourseEdit;
import com.easy.learn.entity.TrainerSalaryPaidSummary;
import org.springframework.stereotype.Service;

@Service
public class CourseEditMapper extends AbstractMapper<CourseEdit, CourseEditDTO>{
    public CourseEditMapper(){
        super(CourseEdit.class,CourseEditDTO.class);
    }
}
