package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.LessonDTO;
import com.easy.learn.response.LessonResponseDTO;
import com.easy.learn.service.LessonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class LessonController {

    @Autowired
    private LessonService service;

    @GetMapping(value = ApiPath.LESSON_GET_BY_COURSE_ID)
    public ResponseEntity<LessonResponseDTO> getLessonsByCourseId(@RequestParam Long id) {
        LessonResponseDTO response = new LessonResponseDTO();
        try {
            List<LessonDTO> lessonDTOList = service.findLessonByCourseId(id);
            response.setList(lessonDTOList);
            response.setMessage("Success get lessons of course");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when get lesson of course:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
