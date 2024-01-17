package com.easy.learn.service.Impl;

import com.easy.learn.dto.TrainerSalaryPaidSummaryDTO;
import com.easy.learn.entity.TrainerSalaryPaidSummary;
import com.easy.learn.mapper.TrainerSalaryPaidMapper;
import com.easy.learn.mapper.TrainerSalaryPaidSummaryMapper;
import com.easy.learn.repository.TrainerSalaryPaidSummaryRepository;
import com.easy.learn.service.TrainerSalaryPaidSummaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TrainerSalaryPaidSummaryServiceImpl implements TrainerSalaryPaidSummaryService {
    @Autowired
    TrainerSalaryPaidSummaryRepository repository;

    @Autowired
    TrainerSalaryPaidSummaryMapper mapper;

    @Override
    public TrainerSalaryPaidSummaryDTO create(TrainerSalaryPaidSummaryDTO tspDTO) {
        TrainerSalaryPaidSummaryDTO result = new TrainerSalaryPaidSummaryDTO();
        try {
            TrainerSalaryPaidSummary tsp = mapper.convertDTOToEntity(tspDTO);
            result = mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
        } catch (Exception e) {
            log.error("Error when creating:", e);
        }
        return result;

    }

    @Override
    public boolean update(TrainerSalaryPaidSummaryDTO dto) {
        try {
            TrainerSalaryPaidSummary tsp = mapper.convertDTOToEntity(dto);
            mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
            return true;
        } catch (Exception e) {
            log.error("Error when creating:", e);
            return false;
        }
    }

    @Override
    public List<TrainerSalaryPaidSummaryDTO> findAll() {
        List<TrainerSalaryPaidSummary> tsp = repository.findAll();
        return tsp == null ? new ArrayList<>() :
                tsp.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }


    @Override
    public boolean delete(Long id) {
        TrainerSalaryPaidSummary tsp = repository.findById(id).get();
        if (tsp != null) {
            repository.delete(tsp);
            return true;
        }
        return false;
    }

    @Override
    public TrainerSalaryPaidSummaryDTO findByTrainerSalaryPaidId(Long id) {
        TrainerSalaryPaidSummary entity = repository.findById(id) != null ? repository.findById(id).get() : new TrainerSalaryPaidSummary();

        return mapper.convertEntityToDTO(entity);
    }
}
