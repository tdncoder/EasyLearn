package com.easy.learn.web.dto.quiz_result;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class Result {
    private int totalCorrect = 0;
    private int totalQuestion = 0;
    private Long lessonEditId;

}
