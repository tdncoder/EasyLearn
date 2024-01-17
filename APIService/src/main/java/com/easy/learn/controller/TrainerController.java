package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.TrainerDTO;
import com.easy.learn.response.TrainerResponseDTO;
import com.easy.learn.service.TrainerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
public class TrainerController {
    @Autowired
    TrainerService service;

    @GetMapping(value = ApiPath.TRAINER_GET_ALL)
    public ResponseEntity<TrainerResponseDTO> getAllTrainer() {
        TrainerResponseDTO response = new TrainerResponseDTO();
        try {
            List<TrainerDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success get all trainers");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when get all trainers:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.TRAINER_GET_ALL_NOT_HAVE_SALARY)
    public ResponseEntity<TrainerResponseDTO> getAllTrainerHaveNotSalary() {
        TrainerResponseDTO response = new TrainerResponseDTO();
        try {
            List<TrainerDTO> list = service.findTrainersNotInSalaryPaid();
            response.setList(list);
            response.setMessage("Success get all trainers");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when get all trainers:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.TRAINER_GET_ID)
    public ResponseEntity<TrainerResponseDTO> getById(@RequestParam Long id) {
        TrainerResponseDTO response = new TrainerResponseDTO();
        try{
            TrainerDTO trainerDTO = service.findById(id);
            if(trainerDTO != null){
                response.setData(trainerDTO);
                response.setMessage("Success get trainer by UUID");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer not found");
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when getting trainer by UUID: "+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = ApiPath.TRAINER_CREATE)
    public ResponseEntity<TrainerResponseDTO> createTrainer(@RequestBody TrainerDTO request) {
        TrainerResponseDTO response = new TrainerResponseDTO();
        try {
            TrainerDTO createdTrainer = service.create(request);
            response.setData(createdTrainer);
            response.setMessage("Trainer created successfully");
            response.setErrorCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage("Error when creating trainer: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.TRAINER_UPDATE)
    public ResponseEntity<TrainerResponseDTO> updateTrainer(@RequestBody TrainerDTO request) {
        TrainerResponseDTO response = new TrainerResponseDTO();
        try {
            boolean updatedTrainer = service.update(request);
            if (updatedTrainer) {
                response.setMessage("Trainer updated successfully");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when updating trainer: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.TRAINER_DELETE)
    public ResponseEntity<TrainerResponseDTO> deleteTrainer(@RequestParam Long id) {
        TrainerResponseDTO response = new TrainerResponseDTO();
        try {
            boolean deleted = service.delete(id);
            if (deleted) {
                response.setMessage("Trainer deleted successfully");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when deleting trainer: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
