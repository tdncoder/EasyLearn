package com.easy.learn.dto.TrainerSalaryPaid;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerSalaryPaid {
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    @NotNull(message = "Payment date is required")
    private Date paymentDate;
    @NotNull(message = "Amount is required")
    private Double amount;
    @NotNull(message = "Description is required")
    private String description;
    @NotNull(message = "CreditDebit is required")
    private String creditDebit;
    private Long trainerId;
    private String trainerFirstName;
    private String trainerLastName;
    private boolean active = true;
}

