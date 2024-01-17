package com.easy.learn.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerSalaryPaidDTO {
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    private Date paymentDate;
    private Double amount;
    private String description;
    private String creditDebit;
    private Long trainerId;
    private String trainerFirstName;  // Newly added field
    private String trainerLastName;
    private boolean active = true;

}
