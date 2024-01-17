package com.easy.learn.service;

import com.easy.learn.dto.TrainerDTO;

import com.easy.learn.entity.Trainer;

import java.util.List;

public interface TrainerService extends BaseService<TrainerDTO>{
    List<TrainerDTO> findTrainersNotInSalaryPaid();

    TrainerDTO findById(Long id);
}