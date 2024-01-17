package com.easy.learn.controller;


import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.CourseDTO;
import com.easy.learn.entity.Course;
import com.easy.learn.response.CourseResponseDTO;
import com.easy.learn.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping(value = ApiPath.STUDENT_COURSE_GET_ALL)
    public ResponseEntity<CourseResponseDTO> getAllCourses() {
        CourseResponseDTO response = new CourseResponseDTO();
        try{
                     List<CourseDTO> list = courseService.findAll();
                        response.setList(list);
                        response.setMessage("Success get all users");
                        response.setErrorCode(200);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    } catch (Exception e) {
                        response.setMessage("Error when get all users:" + e);
                        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                    }
        }

    @GetMapping(value = ApiPath.STUDENT_COURSE_GET_ID)
    public ResponseEntity<CourseResponseDTO> getCourseById(@RequestParam Long id) {
        CourseResponseDTO response = new CourseResponseDTO();
        try {
            CourseDTO course = courseService.findById(id);
            response.setData(course);
            response.setMessage("Success get course by ID");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when get course by ID:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.COURSE_CREATE)
    public ResponseEntity<CourseResponseDTO> addCourse(@RequestBody CourseDTO courseDTO) {
        CourseResponseDTO response = new CourseResponseDTO();
        try {
            CourseDTO createdCourse = courseService.create(courseDTO);
            response.setData(createdCourse);
            response.setMessage("Success create course");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage("Error when create course:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.COURSE_UPDATE)
    public ResponseEntity<CourseResponseDTO> updateCourse( @RequestBody CourseDTO courseDTO) {

        CourseResponseDTO response = new CourseResponseDTO();
        try {
            boolean updated = courseService.update(courseDTO);
            response.setMessage("Success update course");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when update course:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.COURSE_DELETE)
    public ResponseEntity<CourseResponseDTO> deleteCourse(@RequestParam Long id) {
        CourseResponseDTO response = new CourseResponseDTO();
        try {
            boolean deleted = courseService.delete(id);
            if (deleted) {
                response.setMessage("Success delete course");
                response.setErrorCode(200);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Course not found");
                response.setErrorCode(404);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when delete course:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
