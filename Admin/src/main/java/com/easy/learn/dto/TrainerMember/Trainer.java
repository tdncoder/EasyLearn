package com.easy.learn.dto.TrainerMember;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {
    private Long id;
    private String uuid;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    private Date datecreated;
    private String status;
    private String account;
}
