package com.easy.learn.web.callApi;

import com.easy.learn.web.consts.ApiPath;
import com.easy.learn.web.dto.lesson.LessonDTO;
import com.easy.learn.web.dto.quiz.Question;
import com.easy.learn.web.dto.quiz.QuestionDTO;
import com.easy.learn.web.dto.quiz.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizCallService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Quiz quiz;

    public Quiz getListQuestionByLessonID (Long id) {
        String url = apiHostUrl+ ApiPath.TEST_EDIT_GET_LIST_BY_LESSON_ID + "?id=" + id ;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<QuestionDTO> response = restTemplate.exchange(url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<QuestionDTO>() {});
        QuestionDTO questionDTO = response.getBody();
        quiz.setQuestions(questionDTO.getList());
        return quiz;
    }

    public int getResult(Quiz quiz) {
        int correct = 0;
       for (Question q : quiz.getQuestions()) {
           if (q.getRightAnswer().equals(q.getChose())) {
               correct++;
           }
       }
       return correct;
    }
}
