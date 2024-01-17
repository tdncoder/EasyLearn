package com.easy.learn.web.dto.quiz;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class Quiz {
    private List<Question> questions;
}
