package com.easy.learn.web.callApi;


import com.easy.learn.web.consts.ApiPath;
import com.easy.learn.web.dto.lesson.Lesson;
import com.easy.learn.web.dto.lesson.LessonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class LessonCallService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Lesson> getAllLessonOfCourseID(Long id) {
        //Init variables
        String url = apiHostUrl+ ApiPath.LESSON_GET_BY_COURSE_ID + "?id=" + id ;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<LessonDTO> lessonResponse = restTemplate.exchange(url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<LessonDTO>() {});
        LessonDTO lessonDTO = lessonResponse.getBody();
        return lessonDTO.getList();
    }

}
