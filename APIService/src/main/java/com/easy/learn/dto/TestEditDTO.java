package com.easy.learn.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEditDTO {
    private Long id;
    private String question;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String rightAnswer;

    //    @OneToOne(mappedBy = "testEdit")
    private Long lessonEditId;
}
