package com.easy.learn.service.Impl;

import com.easy.learn.dto.WebsiteFinancesSummaryDTO;
import com.easy.learn.entity.WebsiteFinancesSummary;
import com.easy.learn.mapper.WebsiteFinancesSummaryMapper;
import com.easy.learn.repository.WebsiteFinancesSummaryRepository;
import com.easy.learn.service.WebsiteFinancesSummaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WebsiteFinancesSummaryImpl implements WebsiteFinancesSummaryService {
    @Autowired
    WebsiteFinancesSummaryRepository repository;

    @Autowired
    WebsiteFinancesSummaryMapper mapper;
    @Override
    public WebsiteFinancesSummaryDTO create(WebsiteFinancesSummaryDTO websiteFinancesSummaryDTO) {
        WebsiteFinancesSummaryDTO result = new WebsiteFinancesSummaryDTO();
        try {
            WebsiteFinancesSummary tsp = mapper.convertDTOToEntity(websiteFinancesSummaryDTO);
            result = mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
        } catch (Exception e) {
            log.error("Error when creating:", e);
        }
        return result;
    }

    @Override
    public boolean update(WebsiteFinancesSummaryDTO websiteFinancesSummaryDTO) {
        try {
            WebsiteFinancesSummary tsp = mapper.convertDTOToEntity(websiteFinancesSummaryDTO);
            mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
            return true;
        } catch (Exception e) {
            log.error("Error when creating:", e);
            return false;
        }
    }

    @Override
    public List<WebsiteFinancesSummaryDTO> findAll() {
        List<WebsiteFinancesSummary> tsp = repository.findAll();
        return tsp == null ? new ArrayList<>() :
                tsp.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        WebsiteFinancesSummary tsp = repository.findById(id).get();
        if (tsp != null) {
            repository.delete(tsp);
            return true;
        }
        return false;
    }

    @Override
    public WebsiteFinancesSummaryDTO findById(Long id) {
        WebsiteFinancesSummary entity = repository.findById(id) != null ? repository.findById(id).get() : new WebsiteFinancesSummary();

        return mapper.convertEntityToDTO(entity);
    }
}
