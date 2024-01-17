package com.easy.learn.service.Impl;

import com.easy.learn.dto.FinalSalarySummaryDTO;
import com.easy.learn.entity.FinalSalarySummary;
import com.easy.learn.mapper.FinalSalarySummaryMapper;
import com.easy.learn.repository.FinalSalarySummaryRepository;
import com.easy.learn.service.FinalSalarySummaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FinalSalarySummaryImpl implements FinalSalarySummaryService {
    @Autowired
    FinalSalarySummaryRepository repository;

    @Autowired
    FinalSalarySummaryMapper mapper;
    @Override
    public FinalSalarySummaryDTO create(FinalSalarySummaryDTO finalSalarySummaryDTO) {
        FinalSalarySummaryDTO result = new FinalSalarySummaryDTO();
        try {
            FinalSalarySummary tsp = mapper.convertDTOToEntity(finalSalarySummaryDTO);
            result = mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
        } catch (Exception e) {
            log.error("Error when creating:", e);
        }
        return result;
    }

    @Override
    public boolean update(FinalSalarySummaryDTO finalSalarySummaryDTO) {
        try {
            FinalSalarySummary tsp = mapper.convertDTOToEntity(finalSalarySummaryDTO);
            mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
            return true;
        } catch (Exception e) {
            log.error("Error when creating:", e);
            return false;
        }
    }

    @Override
    public List<FinalSalarySummaryDTO> findAll() {
        List<FinalSalarySummary> tsp = repository.findAll();
        return tsp == null ? new ArrayList<>() :
                tsp.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        FinalSalarySummary tsp = repository.findById(id).get();
        if (tsp != null) {
            repository.delete(tsp);
            return true;
        }
        return false;
    }

    @Override
    public FinalSalarySummaryDTO findById(Long id) {
        FinalSalarySummary entity = repository.findById(id) != null ? repository.findById(id).get() : new FinalSalarySummary();

        return mapper.convertEntityToDTO(entity);
    }
}
