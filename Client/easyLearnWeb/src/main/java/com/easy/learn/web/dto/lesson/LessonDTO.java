package com.easy.learn.web.dto.lesson;

import com.easy.learn.web.dto.ReponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonDTO extends ReponseDTO<Lesson> {
    private Long id;
    private String title;
    private String duration;
    private String url;
    private Long courseId;
}
