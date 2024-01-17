package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.TestEditDTO;
import com.easy.learn.response.TestEditResponseDTO;
import com.easy.learn.service.TestEditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
public class TestEditController {
    @Autowired
    TestEditService service;

    @GetMapping(value = ApiPath.TEST_EDIT_GET_ALL)
    public ResponseEntity<TestEditResponseDTO> getAllTestEdit() {
        TestEditResponseDTO response = new TestEditResponseDTO();
        try {
            List<TestEditDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success get all Test Edit records");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting all Test Edit records", e);
            response.setMessage("Error when getting all Test Edit records: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.TEST_EDIT_GET_ONE)
    public ResponseEntity<TestEditResponseDTO> getTestEditById(@RequestParam Long id) {
        TestEditResponseDTO response = new TestEditResponseDTO();

        try {
            TestEditDTO dto = service.findByTestEditId(id);
            response.setData(dto);
            response.setMessage("Success get Test Edit record by ID");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting Test Edit record by ID", e);
            response.setMessage("Error when getting Test Edit record by ID: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.TEST_EDIT_CREATE)
    public ResponseEntity<TestEditResponseDTO> createTestEdit(@RequestBody TestEditDTO dto) {
        TestEditResponseDTO response = new TestEditResponseDTO();

        try {
            TestEditDTO createdDto = service.create(dto);
            response.setData(createdDto);
            response.setMessage("Success creating Test Edit record");
            response.setErrorCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error when creating Test Edit record", e);
            response.setMessage("Error when creating Test Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.TEST_EDIT_UPDATE)
    public ResponseEntity<TestEditResponseDTO> updateTestEdit(@RequestBody TestEditDTO dto) {
        TestEditResponseDTO response = new TestEditResponseDTO();

        try {
            boolean updated = service.update(dto);
            if (updated) {
                response.setMessage("Success updating Test Edit record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when updating Test Edit record", e);
            response.setMessage("Error when updating Test Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.TEST_EDIT_DELETE)
    public ResponseEntity<TestEditResponseDTO> deleteTestEdit(@RequestParam Long id) {
        TestEditResponseDTO response = new TestEditResponseDTO();

        try {
            boolean deleted = service.delete(id);
            if (deleted) {
                response.setMessage("Success deleting Test Edit record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when deleting Test Edit record", e);
            response.setMessage("Error when deleting Test Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = ApiPath.TEST_EDIT_SAVE_OR_UPDATE)
    public ResponseEntity<TestEditResponseDTO> saveOrUpdateTestEdit(@RequestBody TestEditDTO dto) {
        TestEditResponseDTO response = new TestEditResponseDTO();
        try {
            TestEditDTO savedOrUpdateDto = service.saveOrUpdate(dto);
            response.setData(savedOrUpdateDto);
            response.setMessage("Success saving or updating Test Edit record");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when saving or updating Test Edit record", e);
            response.setMessage("Error when saving or updating Test Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.TEST_EDIT_GET_LIST_BY_LESSON_ID)
    public ResponseEntity<TestEditResponseDTO> getAllTestByLessonId(@RequestParam Long id) {
        TestEditResponseDTO response = new TestEditResponseDTO();

        try {
            List<TestEditDTO> list = service.getAllTestByLessonId(id);
            response.setList(list);
            response.setMessage("Success get all Test Edit records by Lesson ID");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting all Test Edit records by Course ID", e);
            response.setMessage("Error when getting all Test Edit records by Lesson ID: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.TEST_EDIT_DELETE_LIST_BY_LESSON_ID)
    public ResponseEntity<TestEditResponseDTO> deleteAllTestByLessonId(@RequestParam Long id) {
        TestEditResponseDTO response = new TestEditResponseDTO();

        try {
            boolean deleted = service.deleteAllTestByLessonId(id);
            if (deleted) {
                response.setMessage("Success deleting Test Edit record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when deleting Test Edit record", e);
            response.setMessage("Error when deleting Test Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.TEST_EDIT_SAVE_FILE_ALL)
    public ResponseEntity<TestEditResponseDTO> saveAllTest(@RequestBody List<TestEditDTO> dto) {
        TestEditResponseDTO response = new TestEditResponseDTO();
        try {
            List<TestEditDTO> createdDto = service.saveListTest(dto);
            response.setList(createdDto);
            response.setMessage("Success creating Test Edit record");
            response.setErrorCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error when creating Test Edit record", e);
            response.setMessage("Error when creating Test Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.TEST_EDIT_GET_LIST_BY_COURSE_ID)
    public ResponseEntity<TestEditResponseDTO> findTestsByCourseId(@RequestParam Long id) {
        TestEditResponseDTO response = new TestEditResponseDTO();

        try {
            List<TestEditDTO> list = service.findTestsByCourseId(id);
            response.setList(list);
            response.setMessage("Success get all Test Edit records by Course ID");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting all Test Edit records by Course ID", e);
            response.setMessage("Error when getting all Test Edit records by Course ID: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(value = ApiPath.TEST_EDIT_DELETE_LIST_BY_COURSE_ID)
    public ResponseEntity<TestEditResponseDTO> deleteAllTestByCourseId(@RequestParam Long id) {
        TestEditResponseDTO response = new TestEditResponseDTO();

        try {
            boolean deleted = service.deleteAllTestByCourseId(id);
            if (deleted) {
                response.setMessage("Success deleting Test Edit record");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Trainer salary record not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error when deleting Test Edit record", e);
            response.setMessage("Error when deleting Test Edit record: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}