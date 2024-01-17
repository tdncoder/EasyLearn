package com.easy.learn.web.dto.quiz;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question implements Serializable {
    private Long id;
    private String question;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String chose;
    private String rightAnswer;
    private Long lessonEditId;


}
