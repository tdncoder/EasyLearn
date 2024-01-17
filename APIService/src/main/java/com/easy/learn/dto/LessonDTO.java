package com.easy.learn.dto;


import com.easy.learn.entity.Course;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class LessonDTO {
    private Long id;
    private String title;
    private String duration;
    private String url;

    private Long courseId;
}
