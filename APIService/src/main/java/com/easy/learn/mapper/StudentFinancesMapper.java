package com.easy.learn.mapper;

import com.easy.learn.dto.StudentFinancesDTO;
import com.easy.learn.entity.StudentFinances;
import org.springframework.stereotype.Service;

@Service
public class StudentFinancesMapper extends AbstractMapper<StudentFinances, StudentFinancesDTO>{
    public StudentFinancesMapper(){
        super(StudentFinances.class, StudentFinancesDTO.class);
    }
}
