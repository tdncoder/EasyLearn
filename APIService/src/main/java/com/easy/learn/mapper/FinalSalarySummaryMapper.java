package com.easy.learn.mapper;

import com.easy.learn.dto.FinalSalarySummaryDTO;
import com.easy.learn.entity.FinalSalarySummary;
import org.springframework.stereotype.Service;

@Service
public class FinalSalarySummaryMapper  extends AbstractMapper<FinalSalarySummary, FinalSalarySummaryDTO>{
    public FinalSalarySummaryMapper(){
        super(FinalSalarySummary.class, FinalSalarySummaryDTO.class);
    }
}
