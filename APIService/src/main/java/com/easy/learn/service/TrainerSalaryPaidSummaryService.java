package com.easy.learn.service;

import com.easy.learn.dto.TrainerSalaryPaidSummaryDTO;


public interface TrainerSalaryPaidSummaryService extends BaseService<TrainerSalaryPaidSummaryDTO>{
    boolean delete(Long id);

    TrainerSalaryPaidSummaryDTO findByTrainerSalaryPaidId(Long id);
}
