package com.easy.learn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalSalarySummaryDTO {
    private Long id;
    private Integer monthNumber;
    private Integer yearNumber;
    private Double totalNumber;
}
