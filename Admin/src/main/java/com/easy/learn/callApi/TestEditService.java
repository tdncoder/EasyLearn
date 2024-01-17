package com.easy.learn.callApi;

import com.easy.learn.consts.ApiPath;
//import com.easy.learn.dto.TestEdit.TestEditDTO;
import com.easy.learn.controller.FileUploadController;
import com.easy.learn.dto.TestEditDTO.TestEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TestEditService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;


    public List<TestEditDTO> getAllTestEdit() {
        String url = apiHostUrl + ApiPath.TEST_EDIT_GET_ALL;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TestEditDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<TestEditDTO>() {});

        TestEditDTO lessonEditDTO = responseEntity.getBody();

        return  lessonEditDTO.getList();
    }
    public TestEditDTO getTestEditById(Long id) {
        String url = apiHostUrl + ApiPath.TEST_EDIT_GET_ONE + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TestEditDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<TestEditDTO>() {});

        TestEditDTO lessonEditDTO = responseEntity.getBody();

        return  lessonEditDTO.getData();
    }
    public TestEditDTO createTestEdit(TestEditDTO dto) {
        String url = apiHostUrl + ApiPath.TEST_EDIT_CREATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TestEditDTO> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<TestEditDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                TestEditDTO.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    public TestEditDTO updateTestEdit(TestEditDTO dto) {
        String url = apiHostUrl + ApiPath.TEST_EDIT_UPDATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TestEditDTO> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<TestEditDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                TestEditDTO.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            // Handle the error case
            // You might want to throw an exception or return null, depending on your use case
            return null;
        }
    }

    public boolean deleteTestEdit(Long id) {
        String url = apiHostUrl + ApiPath.TEST_EDIT_DELETE + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                entity,
                Void.class
        );

        return responseEntity.getStatusCode() == HttpStatus.OK;
    }


    public TestEditDTO saveOrUpdateTestEdit(TestEditDTO dto) {
        String url = apiHostUrl + ApiPath.TEST_EDIT_SAVE_OR_UPDATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TestEditDTO> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<TestEditDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                TestEditDTO.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }


    public List<TestEditDTO> getAllTestByLessonId(Long id) {
        String url = apiHostUrl + ApiPath.TEST_EDIT_GET_LIST_BY_LESSON_ID + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<TestEditDTO> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<TestEditDTO>() {});

            TestEditDTO lessonEditResponseDTO = responseEntity.getBody();

            if (lessonEditResponseDTO != null) {
                return lessonEditResponseDTO.getList();
            }else{
                return Collections.emptyList();
            }
        } catch (Exception e) {
           e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public boolean deleteAllTestByLessonId(Long id) {
        String url = apiHostUrl + ApiPath.TEST_EDIT_DELETE_LIST_BY_LESSON_ID + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                entity,
                Void.class
        );

        return responseEntity.getStatusCode() == HttpStatus.OK;
    }

    public List<TestEditDTO> saveAllTest (List<TestEditDTO> testEditDTOS) {
        String url = apiHostUrl + ApiPath.TEST_EDIT_SAVE_FILE_ALL;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<TestEditDTO>> entity = new HttpEntity<>(testEditDTOS,headers);

        try {
            ResponseEntity<TestEditDTO> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<TestEditDTO>() {});

            TestEditDTO testEditResponseDTO = responseEntity.getBody();

            if (testEditResponseDTO != null) {
                return testEditResponseDTO.getList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<TestEditDTO> getAllTestByCourseId(Long id) {
        String url = apiHostUrl + ApiPath.TEST_EDIT_GET_LIST_BY_COURSE_ID + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<TestEditDTO> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<TestEditDTO>() {});

            TestEditDTO lessonEditResponseDTO = responseEntity.getBody();

            if (lessonEditResponseDTO != null) {
                return lessonEditResponseDTO.getList();
            }else{
                return Collections.emptyList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public boolean deleteAllTestByCourseId(Long id) {
        String url = apiHostUrl + ApiPath.TEST_EDIT_DELETE_LIST_BY_COURSE_ID + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                entity,
                Void.class
        );

        return responseEntity.getStatusCode() == HttpStatus.OK;
    }
}
