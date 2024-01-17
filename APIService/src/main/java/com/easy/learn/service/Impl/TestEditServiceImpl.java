package com.easy.learn.service.Impl;

import com.easy.learn.dto.TestEditDTO;
import com.easy.learn.entity.TestEdit;
import com.easy.learn.mapper.TestEditMapper;
import com.easy.learn.repository.TestEditRepository;
import com.easy.learn.service.TestEditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TestEditServiceImpl implements TestEditService {
    @Autowired
    TestEditRepository repository;

    @Autowired
    TestEditMapper mapper;

    @Override
    public TestEditDTO create(TestEditDTO tspDTO) {
        TestEditDTO result = new TestEditDTO();
        try {
            TestEdit tsp = mapper.convertDTOToEntity(tspDTO);
            result = mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
        } catch (Exception e) {
            log.error("Error when creating:", e);
        }
        return result;

    }

    @Override
    public boolean update(TestEditDTO dto) {
        try {
            TestEdit tsp = mapper.convertDTOToEntity(dto);
            mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
            return true;
        } catch (Exception e) {
            log.error("Error when creating:", e);
            return false;
        }
    }

    @Override
    public List<TestEditDTO> findAll() {
        List<TestEdit> tsp = repository.findAll();

        return tsp == null ? new ArrayList<>() :
                tsp.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }


    @Override
    public boolean delete(Long id) {
        TestEdit tsp = repository.findById(id).get();
        if (tsp != null) {
            repository.delete(tsp);
            return true;
        }
        return false;
    }

    @Override
    public TestEditDTO findByTestEditId(Long id) {
        TestEdit entity = repository.findById(id) != null ? repository.findById(id).get() : new TestEdit();

        return mapper.convertEntityToDTO(entity);
    }

    @Override
    public TestEditDTO saveOrUpdate(TestEditDTO dto) {
        if (dto.getId() == null) {
            return create(dto);
        } else {
            return update(dto) ? dto : null;
        }
    }

    @Override
    public List<TestEditDTO> getAllTestByLessonId(Long id) {
        List<TestEdit> tsp = repository.getAllTestByLessonId(id);
        return tsp == null ? new ArrayList<>() : tsp.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteAllTestByLessonId(Long id){
        List<TestEdit> testToDelete = repository.getAllTestByLessonId(id);
        if (testToDelete != null) {
            repository.deleteAll(testToDelete);

            return true;

        }
        return false;
    }

    @Override
    public List<TestEditDTO> saveListTest(List<TestEditDTO> testEditDTOS) {
        if (testEditDTOS != null) {
            List<TestEdit> entities = mapper.convertDTOListToEntityList(testEditDTOS);
            repository.saveAll(entities);
            return mapper.convertEntityListToDTOList(entities);
        }
        return new ArrayList<>();
    }

    @Override
    public List<TestEditDTO> findTestsByCourseId(Long id) {
       List<TestEdit> entities = repository.findTestsByCourseId(id);

        return entities == null ?
                new ArrayList<>() :
                entities.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteAllTestByCourseId(Long id) {
        List<TestEdit> testToDelete = repository.findTestsByCourseId(id);
        if (testToDelete != null) {
            repository.deleteAll(testToDelete);
            return true;
        }
        return false;
    }
}
