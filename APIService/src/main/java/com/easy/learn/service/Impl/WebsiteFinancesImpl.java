package com.easy.learn.service.Impl;

import com.easy.learn.dto.WebsiteFinancesDTO;
import com.easy.learn.entity.WebsiteFinances;
import com.easy.learn.mapper.WebsiteFinancesMapper;
import com.easy.learn.repository.WebsiteFinancesRepository;
import com.easy.learn.service.WebsiteFinancesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WebsiteFinancesImpl implements WebsiteFinancesService {
    @Autowired
    WebsiteFinancesRepository repository;

    @Autowired
    WebsiteFinancesMapper mapper;
    @Override
    public WebsiteFinancesDTO create(WebsiteFinancesDTO websiteFinancesDTO) {
        WebsiteFinancesDTO result = new WebsiteFinancesDTO();
        try {
            WebsiteFinances tsp = mapper.convertDTOToEntity(websiteFinancesDTO);
            result = mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
        } catch (Exception e) {
            log.error("Error when creating:", e);
        }
        return result;
    }

    @Override
    public boolean update(WebsiteFinancesDTO websiteFinancesDTO) {
        try {
            WebsiteFinances tsp = mapper.convertDTOToEntity(websiteFinancesDTO);
            mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
            return true;
        } catch (Exception e) {
            log.error("Error when creating:", e);
            return false;
        }
    }

    @Override
    public List<WebsiteFinancesDTO> findAll() {
        List<WebsiteFinances> tsp = repository.findAll();
        return tsp == null ? new ArrayList<>() :
                tsp.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        WebsiteFinances tsp = repository.findById(id).get();
        if (tsp != null) {
            repository.delete(tsp);
            return true;
        }
        return false;
    }

    @Override
    public WebsiteFinancesDTO findById(Long id) {
        WebsiteFinances entity = repository.findById(id) != null ? repository.findById(id).get() : new WebsiteFinances();

        return mapper.convertEntityToDTO(entity);
    }
}
