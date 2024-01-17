package com.easy.learn.service;

import com.easy.learn.dto.WebsiteVenueDTO;

public interface WebsiteVenueService extends BaseService<WebsiteVenueDTO>{
    boolean delete(Long id);

    WebsiteVenueDTO findById(Long id);
}
