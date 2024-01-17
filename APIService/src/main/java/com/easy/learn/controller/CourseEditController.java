package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.CourseEditDTO;
import com.easy.learn.response.CourseEditResponseDTO;
import com.easy.learn.service.CourseEditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CourseEditController {
    @Autowired
    CourseEditService service;

    @GetMapping(value = ApiPath.COURSE_EDIT_GET_ALL)
    public ResponseEntity<CourseEditResponseDTO> getAllCourseEdit() {
        CourseEditResponseDTO response = new CourseEditResponseDTO();

        try {
            List<CourseEditDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success get all Course Edit records");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting all Course Edit records", e);
            response.setMessage("Error when getting all Course Edit records: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.COURSE_EDIT_GET_ONE)
    public ResponseEntity<CourseEditResponseDTO> getCourseEditById(@RequestParam Long id) {
        CourseEditResponseDTO response = new CourseEditResponseDTO();

        try {
            CourseEditDTO dto = service.findByCourseEditId(id);
            response.setData(dto);
            response.setMessage("Success get Course Edit record by ID");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting Course Edit record by ID", e);
            response.setMessage("Error when getting Course Edit record by ID: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.COURSE_EDIT_CREATE)
    public ResponseEntity<CourseEditResponseDTO> createCourseEdit(@RequestBody CourseEditDTO dto) {
        CourseEditResponseDTO response = new CourseEditResponseDTO();

        try {
            CourseEditDTO createdDto = service.create(dto);
            response.setData(createdDto);
            response.setMessage("Success creating Course Edit record");
            response.setErrorCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error when creating Course Edit record", e);
            response.setMessage("Error when creating Course Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.COURSE_EDIT_UPDATE)
    public ResponseEntity<CourseEditResponseDTO> updateCourseEdit(@RequestBody CourseEditDTO dto) {
        CourseEditResponseDTO response = new CourseEditResponseDTO();

        try {
            boolean updated = service.update(dto);
            if (updated) {
                response.setMessage("Success updating Course Edit record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when updating Course Edit record", e);
            response.setMessage("Error when updating Course Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.COURSE_EDIT_DELETE)
    public ResponseEntity<CourseEditResponseDTO> deleteCourseEdit(@RequestParam Long id) {
        CourseEditResponseDTO response = new CourseEditResponseDTO();

        try {
            boolean deleted = service.delete(id);
            if (deleted) {
                response.setMessage("Success deleting Course Edit record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when deleting Course Edit record", e);
            response.setMessage("Error when deleting Course Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.COURSE_EDIT_SAVE_OR_UPDATE)
    public ResponseEntity<CourseEditResponseDTO> saveOrUpdateCourseEdit(@RequestBody CourseEditDTO dto) {
        CourseEditResponseDTO response = new CourseEditResponseDTO();

        try {
            CourseEditDTO savedOrUpdateDto = service.saveOrUpdate(dto);
            response.setData(savedOrUpdateDto);
            response.setMessage("Success saving or updating Course Edit record");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when saving or updating Course Edit record", e);
            response.setMessage("Error when saving or updating Course Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}