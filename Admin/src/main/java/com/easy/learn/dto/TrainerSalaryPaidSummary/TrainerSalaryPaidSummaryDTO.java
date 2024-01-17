package com.easy.learn.dto.TrainerSalaryPaidSummary;

import com.easy.learn.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerSalaryPaidSummaryDTO extends ResponseDTO<TrainerSalaryPaidSummary> {
    private Long id;
    private String trainerSalaryPaidId;
    private Integer monthNumber;
    private Integer yearNumber;
    private Double totalNumber;
}
