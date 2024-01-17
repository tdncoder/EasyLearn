package com.easy.learn.service;

import com.easy.learn.dto.ManagerDTO;
import com.easy.learn.dto.StudentDTO;

public interface StudentService extends BaseService<StudentDTO>{

    StudentDTO findById(Long id);
}
