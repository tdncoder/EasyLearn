package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.FeedbackDTO;
import com.easy.learn.response.FeedbackResponseDTO;
import com.easy.learn.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
public class FeedbackController {
    @Autowired
    FeedbackService service;

    @GetMapping(value = ApiPath.FEEDBACK_GET_ALL)
    public ResponseEntity<FeedbackResponseDTO> getAllFeedback() {
        FeedbackResponseDTO response = new FeedbackResponseDTO();
        try {
            List<FeedbackDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success get all students");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when get all students:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = ApiPath.FEEDBACK_GET_UUID)
    public ResponseEntity<FeedbackResponseDTO> getByUuid(@RequestParam String uuid) {
        FeedbackResponseDTO response = new FeedbackResponseDTO();
        try{
            FeedbackDTO studentDTO = service.findByUuid(uuid);
            if(studentDTO != null){
                response.setData(studentDTO);
                response.setMessage("Success get student by UUID");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Feedback not found");
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when getting student by UUID: "+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = ApiPath.FEEDBACK_CREATE)
    public ResponseEntity<FeedbackResponseDTO> createFeedback(@RequestBody FeedbackDTO request) {
        FeedbackResponseDTO response = new FeedbackResponseDTO();
        try {
            FeedbackDTO createdFeedback = service.create(request);
            response.setData(createdFeedback);
            response.setMessage("Feedback created successfully");
            response.setErrorCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage("Error when creating student: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.FEEDBACK_UPDATE)
    public ResponseEntity<FeedbackResponseDTO> updateFeedback(@RequestBody FeedbackDTO request) {
        FeedbackResponseDTO response = new FeedbackResponseDTO();
        try {
            boolean updatedFeedback = service.update(request);
            if (updatedFeedback) {
                response.setMessage("Feedback updated successfully");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Feedback not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when updating student: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.FEEDBACK_DELETE)
    public ResponseEntity<FeedbackResponseDTO> deleteFeedback(@RequestParam Long uuid) {
        FeedbackResponseDTO response = new FeedbackResponseDTO();
        try {
            boolean deleted = service.delete(uuid);
            if (deleted) {
                response.setMessage("Feedback deleted successfully");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Feedback not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when deleting student: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
