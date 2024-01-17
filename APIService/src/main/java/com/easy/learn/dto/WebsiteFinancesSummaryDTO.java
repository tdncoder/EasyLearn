package com.easy.learn.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class WebsiteFinancesSummaryDTO {
    private Long id;
    private Integer monthNumber;
    private Integer yearNumber;
    private Double totalNumber;
}
