package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.TrainerSalaryPaidSummaryDTO;
import com.easy.learn.response.TrainerSalaryPaidSummaryResponseDTO;
import com.easy.learn.service.TrainerSalaryPaidSummaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TrainerSalaryPaidSummaryController {
    @Autowired
    TrainerSalaryPaidSummaryService service;

    @GetMapping(value = ApiPath.TRAINER_SALARY_SUMMARY_GET_ALL)
    public ResponseEntity<TrainerSalaryPaidSummaryResponseDTO> getAllTrainerSalaryPaid() {
        TrainerSalaryPaidSummaryResponseDTO response = new TrainerSalaryPaidSummaryResponseDTO();

        try {
            List<TrainerSalaryPaidSummaryDTO> list = service.findAll();
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

    @GetMapping(value = ApiPath.TRAINER_SALARY_SUMMARY_GET_ONE)
    public ResponseEntity<TrainerSalaryPaidSummaryResponseDTO> getTrainerSalaryPaidSummaryById(@RequestParam Long id) {
        TrainerSalaryPaidSummaryResponseDTO response = new TrainerSalaryPaidSummaryResponseDTO();

        try {
            TrainerSalaryPaidSummaryDTO dto = service.findByTrainerSalaryPaidId(id);
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

    @PostMapping(value = ApiPath.TRAINER_SALARY_SUMMARY_CREATE)
    public ResponseEntity<TrainerSalaryPaidSummaryResponseDTO> createTrainerSalaryPaidSummary(@RequestBody TrainerSalaryPaidSummaryDTO dto) {
        TrainerSalaryPaidSummaryResponseDTO response = new TrainerSalaryPaidSummaryResponseDTO();

        try {
            TrainerSalaryPaidSummaryDTO createdDto = service.create(dto);
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

    @PutMapping(value = ApiPath.TRAINER_SALARY_SUMMARY_UPDATE)
    public ResponseEntity<TrainerSalaryPaidSummaryResponseDTO> updateTrainerSalaryPaidSummary(@RequestBody TrainerSalaryPaidSummaryDTO dto) {
        TrainerSalaryPaidSummaryResponseDTO response = new TrainerSalaryPaidSummaryResponseDTO();

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

    @DeleteMapping(value = ApiPath.TRAINER_SALARY_SUMMARY_DELETE)
    public ResponseEntity<TrainerSalaryPaidSummaryResponseDTO> deleteTrainerSalaryPaidSummary(@RequestParam Long id) {
        TrainerSalaryPaidSummaryResponseDTO response = new TrainerSalaryPaidSummaryResponseDTO();

        try {
            boolean deleted = service.delete(id);
            if (deleted) {
                response.setMessage("Success deleting trainer salary record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when deleting trainer salary record", e);
            response.setMessage("Error when deleting trainer salary record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}