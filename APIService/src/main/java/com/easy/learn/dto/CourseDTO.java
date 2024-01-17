package com.easy.learn.dto;



import com.easy.learn.entity.Lesson;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer totalVideos;
    private String level;
    private Double rating;
}

