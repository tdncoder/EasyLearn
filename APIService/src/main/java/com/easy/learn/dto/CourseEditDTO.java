package com.easy.learn.dto;

import com.easy.learn.entity.LessonEdit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEditDTO {
    private Long id;
    private LocalDateTime lastUpdate;
    private Boolean status;
    private String title;
    private String description;
    private String img;

    private List<LessonEdit> lessonEdits = new ArrayList<>();

}
