package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.TrainerSalaryPaidDTO;
import com.easy.learn.response.TrainerSalaryPaidResponseDTO;
import com.easy.learn.service.TrainerSalaryPaidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TrainerSalaryPaidController {
    @Autowired
    TrainerSalaryPaidService service;

    @GetMapping(value = ApiPath.TRAINER_SALARY_PAID_GET_ALL)
    public ResponseEntity<TrainerSalaryPaidResponseDTO> getAllTrainerSalaryPaid() {
        TrainerSalaryPaidResponseDTO response = new TrainerSalaryPaidResponseDTO();

        try {
            List<TrainerSalaryPaidDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success get all trainer salary records");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting all trainer salary records", e);
            response.setMessage("Error when getting all trainer salary records: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.TRAINER_SALARY_PAID_GET_ONE)
    public ResponseEntity<TrainerSalaryPaidResponseDTO> getTrainerSalaryPaidById(@RequestParam Long id) {
        TrainerSalaryPaidResponseDTO response = new TrainerSalaryPaidResponseDTO();

        try {
            TrainerSalaryPaidDTO dto = service.findById(id);
            response.setData(dto);
            response.setMessage("Success get trainer salary record by ID");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting trainer salary record by ID", e);
            response.setMessage("Error when getting trainer salary record by ID: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.TRAINER_SALARY_PAID_CREATE)
    public ResponseEntity<TrainerSalaryPaidResponseDTO> createTrainerSalaryPaid(@RequestBody TrainerSalaryPaidDTO dto) {
        TrainerSalaryPaidResponseDTO response = new TrainerSalaryPaidResponseDTO();

        try {
            TrainerSalaryPaidDTO createdDto = service.create(dto);
            response.setData(createdDto);
            response.setMessage("Success creating trainer salary record");
            response.setErrorCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error when creating trainer salary record", e);
            response.setMessage("Error when creating trainer salary record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.TRAINER_SALARY_PAID_UPDATE)
    public ResponseEntity<TrainerSalaryPaidResponseDTO> updateTrainerSalaryPaid(@RequestBody TrainerSalaryPaidDTO dto) {
        TrainerSalaryPaidResponseDTO response = new TrainerSalaryPaidResponseDTO();

        try {
            boolean updated = service.update(dto);
            if (updated) {
                response.setMessage("Success updating trainer salary record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when updating trainer salary record", e);
            response.setMessage("Error when updating trainer salary record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.TRAINER_SALARY_PAID_DELETE)
    public ResponseEntity<TrainerSalaryPaidResponseDTO> deleteTrainerSalaryPaid(@RequestParam Long id) {
        TrainerSalaryPaidResponseDTO response = new TrainerSalaryPaidResponseDTO();

        try {
            boolean deleted = service.delete(id);
            if (deleted) {
                response.setMessage("Success deleting trainer salary record");
                response.setErrorCode(HttpStatus.OK.value());
                return ResponseEntity.ok().build();
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            log.error("Error when deleting trainer salary record", e);
            response.setMessage("Error when deleting trainer salary record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
