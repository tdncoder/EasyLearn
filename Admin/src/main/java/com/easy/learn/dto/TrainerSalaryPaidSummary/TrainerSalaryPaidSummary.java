package com.easy.learn.dto.TrainerSalaryPaidSummary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerSalaryPaidSummary implements Serializable {
    private Long id;
    private String trainerSalaryPaidId;
    private Integer monthNumber;
    private Integer yearNumber;
    private Double totalNumber;
}
