package com.easy.learn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFinancesDTO {
    private Long id;
    private String dataRecorded;
    private String courseName;
    private Date paymentDate;
    private Double amount;
    private String transactionType;
    private boolean paymentMethod;
    private boolean description;
    private boolean creditDebit;
    private boolean status;
}
