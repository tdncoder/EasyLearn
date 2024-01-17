package com.easy.learn.callApi;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.TrainerMember.Trainer;
import com.easy.learn.dto.TrainerMember.TrainerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class TrainerService {
    @Value("http://localhost:9090")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Trainer> getAllTrainer() {
        String url = apiHostUrl + ApiPath.TRAINER_GET_ALL;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TrainerDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<TrainerDTO>() {}
        );
        TrainerDTO trainerDTO = responseEntity.getBody();

        return trainerDTO.getList();
    }
    public List<Trainer> getAllTrainerotSalary() {
        String url = apiHostUrl + ApiPath.TRAINER_GET_ALL_NOT_HAVE_SALARY;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TrainerDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<TrainerDTO>() {}
        );
        TrainerDTO trainerDTO = responseEntity.getBody();

        return trainerDTO.getList();
    }
    public Trainer getById(Long id) {
        String url = apiHostUrl + ApiPath.TRAINER_GET_ID + "?id=" + id;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TrainerDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<TrainerDTO>() {
                }
        );
        TrainerDTO trainerDTO = responseEntity.getBody();

        return trainerDTO.getData();
    }
    public Trainer create(TrainerDTO trainerDTO) {
        String url = apiHostUrl + ApiPath.TRAINER_CREATE;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TrainerDTO> entity = new HttpEntity<>(trainerDTO, headers);

        ResponseEntity<Trainer> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                Trainer.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED){
            return responseEntity.getBody();
        } else {
            return null;
        }
    }
    public Trainer update(TrainerDTO trainerDTO) {
        String url = apiHostUrl + ApiPath.TRAINER_UPDATE;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TrainerDTO> entity = new HttpEntity<>(trainerDTO, headers);

        ResponseEntity<Trainer> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                Trainer.class
        );
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            return responseEntity.getBody();
        } else {
            return null;
        }
    }
    public boolean delete(Long id) {
        String url = apiHostUrl + ApiPath.TRAINER_DELETE +"?id=" + id;

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
