package com.easy.learn.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class StudentDTO {

    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String address;
    private String phone;
    private String classId;
    private Long memberManagermentId;
}
