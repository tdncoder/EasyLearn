package com.easy.learn.callApi;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.TrainerSalaryPaidSummary.TrainerSalaryPaidSummary;
import com.easy.learn.dto.TrainerSalaryPaidSummary.TrainerSalaryPaidSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerSalaryPaidSummaryService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;


    public List<TrainerSalaryPaidSummary> getAllTrainerSalaryPaid() {
        String url = apiHostUrl + ApiPath.TRAINER_SALARY_SUMMARY_GET_ALL;
        org.springframework.http.HttpHeaders headers = new HttpHeaders();


        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TrainerSalaryPaidSummaryDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<TrainerSalaryPaidSummaryDTO>() {});

        TrainerSalaryPaidSummaryDTO trainerSalaryPaidDTO = responseEntity.getBody();

        return  trainerSalaryPaidDTO.getList();
    }
    public TrainerSalaryPaidSummary getTrainerSalaryPaidById(Long id) {
        String url = apiHostUrl + ApiPath.TRAINER_SALARY_SUMMARY_GET_ONE + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TrainerSalaryPaidSummaryDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<TrainerSalaryPaidSummaryDTO>() {});

        TrainerSalaryPaidSummaryDTO trainerSalaryPaidDTO = responseEntity.getBody();

        return  trainerSalaryPaidDTO.getData();
    }
    public TrainerSalaryPaidSummary createTrainerSalaryPaid(TrainerSalaryPaidSummaryDTO trainerSalaryPaidDTO) {
        String url = apiHostUrl + ApiPath.TRAINER_SALARY_SUMMARY_CREATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TrainerSalaryPaidSummaryDTO> entity = new HttpEntity<>(trainerSalaryPaidDTO, headers);

        ResponseEntity<TrainerSalaryPaidSummary> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                TrainerSalaryPaidSummary.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    public TrainerSalaryPaidSummary updateTrainerSalaryPaid(TrainerSalaryPaidSummaryDTO trainerSalaryPaidDTO) {
        String url = apiHostUrl + ApiPath.TRAINER_SALARY_SUMMARY_UPDATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TrainerSalaryPaidSummaryDTO> entity = new HttpEntity<>(trainerSalaryPaidDTO, headers);

        ResponseEntity<TrainerSalaryPaidSummary> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                TrainerSalaryPaidSummary.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            // Handle the error case
            // You might want to throw an exception or return null, depending on your use case
            return null;
        }
    }

    public boolean deleteTrainerSalaryPaid(Long id) {
        String url = apiHostUrl + ApiPath.TRAINER_SALARY_SUMMARY_DELETE + "?id=" + id;

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
