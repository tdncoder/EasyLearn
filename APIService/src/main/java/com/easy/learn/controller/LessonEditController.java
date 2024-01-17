package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.LessonEditDTO;
import com.easy.learn.response.LessonEditResponseDTO;
import com.easy.learn.service.LessonEditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class LessonEditController {
    @Autowired
    LessonEditService service;

    @GetMapping(value = ApiPath.LESSON_EDIT_GET_ALL)
    public ResponseEntity<LessonEditResponseDTO> getAllLessonEdit() {
        LessonEditResponseDTO response = new LessonEditResponseDTO();

        try {
            List<LessonEditDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success get all Lesson Edit records");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting all Lesson Edit records", e);
            response.setMessage("Error when getting all Lesson Edit records: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.LESSON_EDIT_GET_ONE)
    public ResponseEntity<LessonEditResponseDTO> getLessonEditById(@RequestParam Long id) {
        LessonEditResponseDTO response = new LessonEditResponseDTO();

        try {
            LessonEditDTO dto = service.findByLessonEditId(id);
            response.setData(dto);
            response.setMessage("Success get Lesson Edit record by ID");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting Lesson Edit record by ID", e);
            response.setMessage("Error when getting Lesson Edit record by ID: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.LESSON_EDIT_CREATE)
    public ResponseEntity<LessonEditResponseDTO> createLessonEdit(@RequestBody LessonEditDTO dto) {
        LessonEditResponseDTO response = new LessonEditResponseDTO();

        try {
            LessonEditDTO createdDto = service.create(dto);
            response.setData(createdDto);
            response.setMessage("Success creating Lesson Edit record");
            response.setErrorCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error when creating Lesson Edit record", e);
            response.setMessage("Error when creating Lesson Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.LESSON_EDIT_UPDATE)
    public ResponseEntity<LessonEditResponseDTO> updateLessonEdit(@RequestBody LessonEditDTO dto) {
        LessonEditResponseDTO response = new LessonEditResponseDTO();

        try {
            boolean updated = service.update(dto);
            if (updated) {
                response.setMessage("Success updating Lesson Edit record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when updating Lesson Edit record", e);
            response.setMessage("Error when updating Lesson Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.LESSON_EDIT_DELETE)
    public ResponseEntity<LessonEditResponseDTO> deleteLessonEdit(@RequestParam Long id) {
        LessonEditResponseDTO response = new LessonEditResponseDTO();

        try {
            boolean deleted = service.delete(id);
            if (deleted) {
                response.setMessage("Success deleting Lesson Edit record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when deleting Lesson Edit record", e);
            response.setMessage("Error when deleting Lesson Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = ApiPath.LESSON_EDIT_SAVE_OR_UPDATE)
    public ResponseEntity<LessonEditResponseDTO> saveOrUpdateLessonEdit(@RequestBody LessonEditDTO dto) {
        LessonEditResponseDTO response = new LessonEditResponseDTO();
        try {
            LessonEditDTO savedOrUpdateDto = service.saveOrUpdate(dto);
            response.setData(savedOrUpdateDto);
            response.setMessage("Success saving or updating Lesson Edit record");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when saving or updating Lesson Edit record", e);
            response.setMessage("Error when saving or updating Lesson Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.LESSON_EDIT_GET_LIST_BY_COURSE_ID)
    public ResponseEntity<LessonEditResponseDTO> getAllLessonByCourseId(@RequestParam Long id) {
        LessonEditResponseDTO response = new LessonEditResponseDTO();

        try {
            List<LessonEditDTO> list = service.getAllLessonByCourseId(id);
            response.setList(list);
            response.setMessage("Success get all Lesson Edit records by Course ID");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting all Lesson Edit records by Course ID", e);
            response.setMessage("Error when getting all Lesson Edit records by Course ID: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.LESSON_EDIT_DELETE_LIST_BY_COURSE_ID)
    public ResponseEntity<LessonEditResponseDTO> deleteAllLessonByCourseId(@RequestParam Long id) {
        LessonEditResponseDTO response = new LessonEditResponseDTO();

        try {
            boolean deleted = service.deleteAllLessonByCourseId(id);
            if (deleted) {
                response.setMessage("Success deleting Lesson Edit record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when deleting Lesson Edit record", e);
            response.setMessage("Error when deleting Lesson Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}