package com.easy.learn.mapper;

import com.easy.learn.dto.StudentDTO;
import com.easy.learn.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper extends AbstractMapper<Student, StudentDTO>{
    public StudentMapper(){
       super( Student.class, StudentDTO.class);
    }
}
