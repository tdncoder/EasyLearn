package com.easy.learn.dto.CourseEdit;

//import com.easy.learn.Enum.Status;
//import com.easy.learn.dto.CourseEdit.CourseEdit;
import com.easy.learn.dto.LessonEdit.LessonEditDTO;
import com.easy.learn.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
//public class CourseEditDTO extends ResponseDTO<CourseEdit> {
public class CourseEditDTO extends ResponseDTO<CourseEditDTO> {
    private Long id;
    private LocalDateTime lastUpdate;
    private Boolean status;
    private String title;
    private String description;
    private String img;

    private List<LessonEditDTO> lessonEdits = new ArrayList<>();
}
