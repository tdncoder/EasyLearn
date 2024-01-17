package com.easy.learn.service;

import com.easy.learn.dto.StudentFinancesDTO;

public interface StudentFinancesService extends BaseService<StudentFinancesDTO>{
    boolean delete(Long id);
    StudentFinancesDTO findById(Long id);
}
