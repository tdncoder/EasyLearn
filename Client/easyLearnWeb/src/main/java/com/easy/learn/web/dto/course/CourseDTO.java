package com.easy.learn.web.dto.course;

import com.easy.learn.web.dto.ReponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO extends ReponseDTO<Course> {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer totalVideos;
    private String level;
    private Double rating;
}
