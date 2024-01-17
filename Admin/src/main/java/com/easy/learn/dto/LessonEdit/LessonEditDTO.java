package com.easy.learn.dto.LessonEdit;

//import com.easy.learn.Enum.Status;
//import com.easy.learn.dto.CourseEdit.CourseEdit;
import com.easy.learn.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonEditDTO extends ResponseDTO<LessonEditDTO> {
    private Long id;
    @NotNull(message = "Number cannot be null")
    @Digits(integer = 2, fraction = 0, message = "Number must be a two-digit whole number")
    private Long number;

    @NotNull(message = "Title cant be null")
    @Size(max = 50, message = "Max size 50 character")
    private String title;

    private LocalDateTime lastUpdate;

    private String video;

    private String test;
    private Integer duration;

    private Long courseEditId;

}
