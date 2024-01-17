package com.easy.learn.service;

import com.easy.learn.dto.FinalSalarySummaryDTO;

public interface FinalSalarySummaryService extends BaseService<FinalSalarySummaryDTO>{
    boolean delete(Long id);

    FinalSalarySummaryDTO findById(Long id);
}
