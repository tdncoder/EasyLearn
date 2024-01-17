package com.easy.learn.mapper;


import com.easy.learn.dto.TrainerDTO;

import com.easy.learn.entity.Trainer;
import org.springframework.stereotype.Service;

@Service
public class TrainerMapper extends AbstractMapper<Trainer, TrainerDTO>{
    public TrainerMapper(){
        super( Trainer.class, TrainerDTO.class);
    }
}
