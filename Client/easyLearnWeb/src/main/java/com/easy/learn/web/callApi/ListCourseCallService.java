package com.easy.learn.web.callApi;

import com.easy.learn.web.consts.ApiPath;
import com.easy.learn.web.dto.course.ListCourse;
import com.easy.learn.web.dto.course.ListCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ListCourseCallService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<ListCourse> getAllListCourses() {
        String url = apiHostUrl + ApiPath.COURSE_EDIT_GET_ALL;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ListCourseDTO> listCourseResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<ListCourseDTO>() {}
        );

        ListCourseDTO listCourseDTO = listCourseResponse.getBody();
        return listCourseDTO.getList();
    }

    public ListCourse getListCourseById(Long id) {
        String url = apiHostUrl + ApiPath.COURSE_EDIT_GET_ONE + "?id=" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ListCourseDTO> listCourseResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<ListCourseDTO>() {}
        );

        ListCourseDTO listCourseDTO = listCourseResponse.getBody();
        return listCourseDTO.getData();
    }

    public ListCourse addListCourse(ListCourseDTO listCourseDTO) {
        String url = apiHostUrl + ApiPath.COURSE_CREATE;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ListCourseDTO> entity = new HttpEntity<>(listCourseDTO, headers);

        ResponseEntity<ListCourse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                ListCourse.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    public ListCourseDTO updateListCourse(Long id, ListCourseDTO listCourseDTO) {
        String url = apiHostUrl + ApiPath.COURSE_UPDATE + "/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ListCourseDTO> entity = new HttpEntity<>(listCourseDTO, headers);

        ResponseEntity<ListCourseDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                ListCourseDTO.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    public boolean deleteListCourse(Long id) {
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
