package com.easy.learn.dto;


import com.easy.learn.entity.CourseEdit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonEditDTO {
    private Long id;
    private Long number;
    private String title;
    private LocalDateTime lastUpdate;
    private String video;
    private String test;
    private Integer duration;

    private Long courseEditId;
}
