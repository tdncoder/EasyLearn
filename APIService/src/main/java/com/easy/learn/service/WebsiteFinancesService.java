package com.easy.learn.service;

import com.easy.learn.dto.WebsiteFinancesDTO;

public interface WebsiteFinancesService extends BaseService<WebsiteFinancesDTO>{
    boolean delete(Long id);
    WebsiteFinancesDTO findById(Long id);
}
