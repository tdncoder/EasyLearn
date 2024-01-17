package com.easy.learn.web.callApi;

import com.easy.learn.web.consts.ApiPath;
import com.easy.learn.web.dto.course.Course;
import com.easy.learn.web.dto.course.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseCallService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Course> getAllCourses() {
        String url = apiHostUrl + ApiPath.STUDENT_COURSE_GET_ALL;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CourseDTO> courseResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<CourseDTO>() {}
        );

        CourseDTO courseDTO = courseResponse.getBody();
        return courseDTO.getList();
    }

    public Course getCourseById(Long id) {
        String url = apiHostUrl + ApiPath.STUDENT_COURSE_GET_ID + "?id=" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<CourseDTO> courseResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<CourseDTO>() {}
        );

        CourseDTO courseDTO = courseResponse.getBody();
        return courseDTO.getData();
    }

    public Course addCourse(CourseDTO courseDTO) {
        String url = apiHostUrl + ApiPath.COURSE_CREATE;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CourseDTO> entity = new HttpEntity<>(courseDTO, headers);

        ResponseEntity<Course> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                Course.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        String url = apiHostUrl + ApiPath.COURSE_UPDATE + "/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CourseDTO> entity = new HttpEntity<>(courseDTO, headers);

        ResponseEntity<CourseDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                CourseDTO.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    public boolean deleteCourse(Long id) {
        String url = apiHostUrl + ApiPath.COURSE_DELETE + "?id=" + id;

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
