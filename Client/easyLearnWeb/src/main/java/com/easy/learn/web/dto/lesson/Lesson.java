package com.easy.learn.web.dto.lesson;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson implements Serializable {
    private Long id;
    private String title;
    private String duration;
    private String url;
    private Long courseId;
}
