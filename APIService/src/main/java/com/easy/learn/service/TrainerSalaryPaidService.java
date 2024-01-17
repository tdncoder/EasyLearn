package com.easy.learn.service;

import com.easy.learn.dto.TrainerSalaryPaidDTO;

public interface TrainerSalaryPaidService extends BaseService<TrainerSalaryPaidDTO> {
    boolean delete(Long id);

    TrainerSalaryPaidDTO findById(Long id);
}
