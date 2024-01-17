package com.easy.learn.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class TrainerDTO {
    private Long id;
    private String uuid;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    private Date dateCreated;

    private String status;
}
