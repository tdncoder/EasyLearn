package com.easy.learn.service.Impl;

import com.easy.learn.dto.StudentFinancesDTO;
import com.easy.learn.entity.StudentFinances;
import com.easy.learn.mapper.StudentFinancesMapper;
import com.easy.learn.repository.StudentFinancesRepository;
import com.easy.learn.service.StudentFinancesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentFinancesImpl implements StudentFinancesService {
    @Autowired
    StudentFinancesRepository repository;

    @Autowired
    StudentFinancesMapper mapper;

    @Override
    public StudentFinancesDTO create(StudentFinancesDTO studentFinancesDTO) {
        StudentFinancesDTO result = new StudentFinancesDTO();
        try {
            StudentFinances tsp = mapper.convertDTOToEntity(studentFinancesDTO);
            result = mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
        } catch (Exception e) {
            log.error("Error when creating:", e);
        }
        return result;
    }

    @Override
    public boolean update(StudentFinancesDTO studentFinancesDTO) {
        try {
            StudentFinances tsp = mapper.convertDTOToEntity(studentFinancesDTO);
            mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
            return true;
        } catch (Exception e) {
            log.error("Error when creating:", e);
            return false;
        }
    }

    @Override
    public List<StudentFinancesDTO> findAll() {
        List<StudentFinances> tsp = repository.findAll();
        return tsp == null ? new ArrayList<>() :
                tsp.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        StudentFinances tsp = repository.findById(id).get();
        if (tsp != null) {
            repository.delete(tsp);
            return true;
        }
        return false;
    }

    @Override
    public StudentFinancesDTO findById(Long id) {
        StudentFinances entity = repository.findById(id) != null ? repository.findById(id).get() : new StudentFinances();

        return mapper.convertEntityToDTO(entity);
    }
}
