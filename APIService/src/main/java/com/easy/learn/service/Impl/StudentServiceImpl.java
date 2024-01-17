package com.easy.learn.service.Impl;

import com.easy.learn.dto.StudentDTO;
import com.easy.learn.entity.Student;
import com.easy.learn.mapper.StudentMapper;
import com.easy.learn.repository.StudentRepository;
import com.easy.learn.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository repository;
    @Autowired
    StudentMapper mapper;

    @Override
    public StudentDTO create(StudentDTO dto) {
        StudentDTO result = new StudentDTO();
        try {
            Student student = mapper.convertDTOToEntity(dto);
            result =mapper.convertEntityToDTO(repository.saveAndFlush(student));
        } catch (Exception ex) {
            log.error("Error when creating:", ex);
        }

        return result;
    }

    @Override
    public boolean update(StudentDTO dto) {
        try {
            Student student = mapper.convertDTOToEntity(dto);
            mapper.convertEntityToDTO(repository.saveAndFlush(student));
            return true;
        } catch (Exception ex) {
            log.error("Error when updating:", ex);
            return false;
        }
    }

    @Override
    public List<StudentDTO> findAll() {
        List<Student> students = repository.findAll();
        return students == null ? new ArrayList<>()
                : students.stream().map(entity -> mapper.convertEntityToDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        Student student = repository.findById(id).get();
        if (student != null) {
            repository.delete(student);
            return true;
        }
        return false;
    }
    @Override
    public StudentDTO findById(Long id) {
        Student student = repository.findById(id) != null ? repository.findById(id).get() : new Student();

        return mapper.convertEntityToDTO(student);
    }
}
