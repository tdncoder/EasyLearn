package com.easy.learn.service.Impl;

import com.easy.learn.dto.TrainerDTO;
import com.easy.learn.entity.Trainer;
import com.easy.learn.mapper.TrainerMapper;
import com.easy.learn.repository.TrainerRepository;
import com.easy.learn.service.TrainerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Slf4j
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    TrainerRepository repository;
    @Autowired
    TrainerMapper mapper;

    @Override
    public TrainerDTO create(TrainerDTO dto) {
        TrainerDTO result = new TrainerDTO();
        try {
            Trainer trainer = mapper.convertDTOToEntity(dto);
            result =mapper.convertEntityToDTO(repository.saveAndFlush(trainer));
        } catch (Exception ex) {
            log.error("Error when creating:", ex);
        }

        return result;
    }

    @Override
    public boolean update(TrainerDTO dto) {
        try {
            Trainer trainer = mapper.convertDTOToEntity(dto);
            mapper.convertEntityToDTO(repository.saveAndFlush(trainer));
            return true;
        } catch (Exception ex) {
            log.error("Error when updating:", ex);
            return false;
        }
    }

    @Override
    public List<TrainerDTO> findAll() {
        List<Trainer> trainers = repository.findAll();
        return trainers == null ? new ArrayList<>()
                : trainers.stream().map(entity -> mapper.convertEntityToDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        Trainer trainer = repository.findById(id).get();
        if (trainer != null) {
            repository.delete(trainer);
            return true;
        }
        return false;
    }

    @Override
    public List<TrainerDTO> findTrainersNotInSalaryPaid() {
        List<Trainer> trainers = repository.findTrainersNotInSalaryPaid();
        return trainers == null ? new ArrayList<>()
                : trainers.stream().map(entity -> mapper.convertEntityToDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public TrainerDTO findById(Long id) {
        Trainer trainer = repository.findById(id) != null ? repository.findById(id).get() : new Trainer();

        return mapper.convertEntityToDTO(trainer);
    }
}
