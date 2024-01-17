package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.StudentDTO;
import com.easy.learn.response.StudentResponseDTO;
import com.easy.learn.response.StudentResponseDTO;
import com.easy.learn.service.StudentService;
import com.easy.learn.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping(value = ApiPath.STUDENT_GET_ALL)
    public ResponseEntity<StudentResponseDTO> getAllStudent() {
        StudentResponseDTO response = new StudentResponseDTO();
        try {
            List<StudentDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success get all students");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when get all students:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = ApiPath.STUDENT_GET_ID)
    public ResponseEntity<StudentResponseDTO> getById(@RequestParam Long id) {
        StudentResponseDTO response = new StudentResponseDTO();
        try{
            StudentDTO studentDTO = service.findById(id);
            if(studentDTO != null){
                response.setData(studentDTO);
                response.setMessage("Success get student by UUID");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Student not found");
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when getting student by UUID: "+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = ApiPath.STUDENT_CREATE)
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentDTO request) {
        StudentResponseDTO response = new StudentResponseDTO();
        try {
            StudentDTO createdStudent = service.create(request);
            response.setData(createdStudent);
            response.setMessage("Student created successfully");
            response.setErrorCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage("Error when creating student: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.STUDENT_UPDATE)
    public ResponseEntity<StudentResponseDTO> updateStudent(@RequestBody StudentDTO request) {
        StudentResponseDTO response = new StudentResponseDTO();
        try {
            boolean updatedStudent = service.update(request);
            if (updatedStudent) {
                response.setMessage("Student updated successfully");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Student not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when updating student: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.STUDENT_DELETE)
    public ResponseEntity<StudentResponseDTO> deleteStudent(@RequestParam Long id) {
        StudentResponseDTO response = new StudentResponseDTO();
        try {
            boolean deleted = service.delete(id);
            if (deleted) {
                response.setMessage("Student deleted successfully");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Student not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when deleting student: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
