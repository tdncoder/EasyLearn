package com.easy.learn.service;

import com.easy.learn.dto.WebsiteFinancesSummaryDTO;

public interface WebsiteFinancesSummaryService extends BaseService<WebsiteFinancesSummaryDTO>{
    boolean delete(Long id);
    WebsiteFinancesSummaryDTO findById(Long id);
}
