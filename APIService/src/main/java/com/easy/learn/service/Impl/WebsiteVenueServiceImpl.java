package com.easy.learn.service.Impl;

import com.easy.learn.dto.WebsiteVenueDTO;
import com.easy.learn.entity.WebsiteVenue;
import com.easy.learn.mapper.WebsiteVenueMapper;
import com.easy.learn.repository.WebsiteVenueRepository;
import com.easy.learn.service.WebsiteVenueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WebsiteVenueServiceImpl implements WebsiteVenueService {
    @Autowired
    WebsiteVenueRepository repository;

    @Autowired
    WebsiteVenueMapper mapper;
    @Override
    public WebsiteVenueDTO create(WebsiteVenueDTO websiteVenueDTO) {
        WebsiteVenueDTO result = new WebsiteVenueDTO();
        try {
            WebsiteVenue tsp = mapper.convertDTOToEntity(websiteVenueDTO);
            result = mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
        } catch (Exception e) {
            log.error("Error when creating:", e);
        }
        return result;
    }

    @Override
    public boolean update(WebsiteVenueDTO websiteVenueDTO) {
        try {
            WebsiteVenue tsp = mapper.convertDTOToEntity(websiteVenueDTO);
            mapper.convertEntityToDTO(repository.saveAndFlush(tsp));
            return true;
        } catch (Exception e) {
            log.error("Error when creating:", e);
            return false;
        }
    }

    @Override
    public List<WebsiteVenueDTO> findAll() {
        List<WebsiteVenue> tsp = repository.findAll();
        return tsp == null ? new ArrayList<>() :
                tsp.stream().map(entity -> mapper.convertEntityToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        WebsiteVenue tsp = repository.findById(id).get();
        if (tsp != null) {
            repository.delete(tsp);
            return true;
        }
        return false;
    }

    @Override
    public WebsiteVenueDTO findById(Long id) {
        WebsiteVenue entity = repository.findById(id) != null ? repository.findById(id).get() : new WebsiteVenue();

        return mapper.convertEntityToDTO(entity);
    }
}
