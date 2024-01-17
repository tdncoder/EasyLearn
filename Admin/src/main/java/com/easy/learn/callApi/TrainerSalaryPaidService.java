package com.easy.learn.callApi;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaid;
import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaidDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerSalaryPaidService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<TrainerSalaryPaid> getAllTrainerSalaryPaid() {
        String url = apiHostUrl + ApiPath.TRAINER_SALARY_PAID_GET_ALL;
        org.springframework.http.HttpHeaders headers = new HttpHeaders();


        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TrainerSalaryPaidDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<TrainerSalaryPaidDTO>() {
                });

        TrainerSalaryPaidDTO trainerSalaryPaidDTO = responseEntity.getBody();

        return trainerSalaryPaidDTO.getList();
    }


    public TrainerSalaryPaid getTrainerSalaryPaidById(Long id) {
        String url = apiHostUrl + ApiPath.TRAINER_SALARY_PAID_GET_ONE + "?id=" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TrainerSalaryPaidDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<TrainerSalaryPaidDTO>() {
                });

        TrainerSalaryPaidDTO trainerSalaryPaidDTO = responseEntity.getBody();

        return trainerSalaryPaidDTO.getData();
    }

    public TrainerSalaryPaid createTrainerSalaryPaid(TrainerSalaryPaidDTO trainerSalaryPaidDTO) {
        String url = apiHostUrl + ApiPath.TRAINER_SALARY_PAID_CREATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TrainerSalaryPaidDTO> entity = new HttpEntity<>(trainerSalaryPaidDTO, headers);

        ResponseEntity<TrainerSalaryPaid> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                TrainerSalaryPaid.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    public TrainerSalaryPaid updateTrainerSalaryPaid(TrainerSalaryPaidDTO trainerSalaryPaidDTO) {
        String url = apiHostUrl + ApiPath.TRAINER_SALARY_PAID_UPDATE;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TrainerSalaryPaidDTO> entity = new HttpEntity<>(trainerSalaryPaidDTO, headers);

        ResponseEntity<TrainerSalaryPaid> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                TrainerSalaryPaid.class
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
        String url = apiHostUrl + ApiPath.TRAINER_SALARY_PAID_DELETE + "?id=" + id;

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
