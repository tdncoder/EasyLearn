package com.easy.learn.web.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer totalVideos;
    private String level;
    private Double rating;
}
