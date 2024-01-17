package com.easy.learn.service.Impl;

import com.easy.learn.dto.LessonEditDTO;
import com.easy.learn.entity.LessonEdit;
import com.easy.learn.mapper.LessonEditMapper;
import com.easy.learn.repository.LessonEditRepository;
import com.easy.learn.service.LessonEditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LessonEditServiceImpl implements LessonEditService {
    @Autowired
    LessonEditRepository repository;

    @Autowired
    LessonEditMapper mapper;

    @Override
    public LessonEditDTO create(LessonEditDTO tspDTO) {
        LessonEditDTO result = new LessonEditDTO();
        try {
            LessonEdit tsp = mapper.convertDTOToEntity(tspDTO);
            result = mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
        } catch (Exception e) {
            log.error("Error when creating:", e);
        }
        return result;

    }

    @Override
    public boolean update(LessonEditDTO dto) {
        try {
            LessonEdit tsp = mapper.convertDTOToEntity(dto);
            mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
            return true;
        } catch (Exception e) {
            log.error("Error when creating:", e);
            return false;
        }
    }

    @Override
    public List<LessonEditDTO> findAll() {
        List<LessonEdit> tsp = repository.findAll();
        return tsp == null ? new ArrayList<>() :
                tsp.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }


    @Override
    public boolean delete(Long id) {
        LessonEdit tsp = repository.findById(id).get();
        if (tsp != null) {
            repository.delete(tsp);
            return true;
        }
        return false;
    }

    @Override
    public LessonEditDTO findByLessonEditId(Long id) {
        LessonEdit entity = repository.findById(id) != null ? repository.findById(id).get() : new LessonEdit();

        return mapper.convertEntityToDTO(entity);
    }

    @Override
    public LessonEditDTO saveOrUpdate(LessonEditDTO dto) {
        if (dto.getId() == null) {
            return create(dto);
        } else {
            return update(dto) ? dto : null;
        }
    }

    @Override
    public List<LessonEditDTO> getAllLessonByCourseId(Long id) {
        List<LessonEdit> tsp = repository.getAllLessonByCourseId(id);
        return tsp == null ? new ArrayList<>() : tsp.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteAllLessonByCourseId(Long id){
        List<LessonEdit> lessonsToDelete = repository.getAllLessonByCourseId(id);
        if (lessonsToDelete != null) {
            repository.deleteAll(lessonsToDelete);
            return true;
        }
        return false;
    }

}
