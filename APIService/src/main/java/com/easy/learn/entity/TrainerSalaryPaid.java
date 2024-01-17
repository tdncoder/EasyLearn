package com.easy.learn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerSalaryPaid extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    private Date paymentDate;
    private Double amount;

    private String description;
    private String creditDebit;
    private Long trainerId;
    private String trainerFirstName;
    private String trainerLastName;
    private boolean active = true;


}
