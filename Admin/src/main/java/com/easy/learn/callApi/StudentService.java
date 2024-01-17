package com.easy.learn.callApi;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.Student.Student;
import com.easy.learn.dto.Student.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class StudentService {
    @Value("http://localhost:9090")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Student> getAllStudent() {
        String url = apiHostUrl + ApiPath.STUDENT_GET_ALL;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<StudentDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<StudentDTO>() {}
        );
        StudentDTO studentDTO = responseEntity.getBody();

        return studentDTO.getList();
    }
    public Student getById(Long id) {
        String url = apiHostUrl + ApiPath.STUDENT_GET_ID + "?id=" + id;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<StudentDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<StudentDTO>() {
                }
        );
        StudentDTO studentDTO = responseEntity.getBody();

        return studentDTO.getData();
    }
    public Student create(StudentDTO studentDTO) {
        String url = apiHostUrl + ApiPath.STUDENT_CREATE;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<StudentDTO> entity = new HttpEntity<>(studentDTO, headers);

        ResponseEntity<Student> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                Student.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED){
            return responseEntity.getBody();
        } else {
            return null;
        }
    }
    public Student update(StudentDTO studentDTO) {
        String url = apiHostUrl + ApiPath.STUDENT_UPDATE;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<StudentDTO> entity = new HttpEntity<>(studentDTO, headers);

        ResponseEntity<Student> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                Student.class
        );
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity.getBody();
        } else {
            return null;
        }
    }
    public boolean delete(Long id) {
        String url = apiHostUrl + ApiPath.STUDENT_DELETE +"?id=" + id;

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
