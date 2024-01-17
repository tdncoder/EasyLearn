package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.StudentFinancesDTO;
import com.easy.learn.response.StudentFinancesResponseDTO;
import com.easy.learn.service.StudentFinancesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class    StudentFinancesController {
    @Autowired
    StudentFinancesService service;

    @GetMapping(value = ApiPath.STUDENT_FINANCES_GET_ALL)
        public ResponseEntity<StudentFinancesResponseDTO> getAllStudentFinances() {
            StudentFinancesResponseDTO response = new StudentFinancesResponseDTO();

            try {
                List<StudentFinancesDTO> list = service.findAll();
                response.setList(list);
                response.setMessage("Success get all Student Finances records");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Error when getting all Student Finances records", e);
                response.setMessage("Error when getting all Student Finances records: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @GetMapping(value = ApiPath.STUDENT_FINANCES_GET_ONE)
        public ResponseEntity<StudentFinancesResponseDTO> getStudentFinancesById(@RequestParam Long id) {
            StudentFinancesResponseDTO response = new StudentFinancesResponseDTO();

            try {
                StudentFinancesDTO dto = service.findById(id);
                response.setData(dto);
                response.setMessage("Success get Student Finances record by ID");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Error when getting Student Finances record by ID", e);
                response.setMessage("Error when getting Student Finances record by ID: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @PostMapping(value = ApiPath.STUDENT_FINANCES_CREATE)
        public ResponseEntity<StudentFinancesResponseDTO> createStudentFinances(@RequestBody StudentFinancesDTO dto) {
            StudentFinancesResponseDTO response = new StudentFinancesResponseDTO();

            try {
                StudentFinancesDTO createdDto = service.create(dto);
                response.setData(createdDto);
                response.setMessage("Success creating Student Finances record");
                response.setErrorCode(HttpStatus.CREATED.value());
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Error when creating Student Finances record", e);
                response.setMessage("Error when creating Student Finances record: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @PutMapping(value = ApiPath.STUDENT_FINANCES_UPDATE)
        public ResponseEntity<StudentFinancesResponseDTO> updateStudentFinances(@RequestBody StudentFinancesDTO dto) {
            StudentFinancesResponseDTO response = new StudentFinancesResponseDTO();

            try {
                boolean updated = service.update(dto);
                if (updated) {
                    response.setMessage("Success updating Student Finances record");
                    response.setErrorCode(HttpStatus.OK.value());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.setMessage("Student Finances record not found");
                    response.setErrorCode(HttpStatus.NOT_FOUND.value());
                    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                log.error("Error when updating Student Finances record", e);
                response.setMessage("Error when updating Student Finances record: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @DeleteMapping(value = ApiPath.STUDENT_FINANCES_DELETE)
        public ResponseEntity<StudentFinancesResponseDTO> deleteStudentFinances(@RequestParam Long id) {
            StudentFinancesResponseDTO response = new StudentFinancesResponseDTO();

            try {
                boolean deleted = service.delete(id);
                if (deleted) {
                    response.setMessage("Success deleting Student Finances record");
                    response.setErrorCode(HttpStatus.OK.value());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.setMessage("Student Finances record not found");
                    response.setErrorCode(HttpStatus.NOT_FOUND.value());
                    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                log.error("Error when deleting Student Finances record", e);
                response.setMessage("Error when deleting Student Finances record: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


}
