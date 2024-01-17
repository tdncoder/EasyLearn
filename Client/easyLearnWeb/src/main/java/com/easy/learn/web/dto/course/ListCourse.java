package com.easy.learn.web.dto.course;

import com.easy.learn.web.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCourse implements Serializable {
    private Long id;
    private LocalDateTime lastUpdate;
    private Status status;
    private String title;
    private String description;
    private String img;
    private String file;
}
