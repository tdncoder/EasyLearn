package com.easy.learn.callApi;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.Manager.Manager;
import com.easy.learn.dto.Manager.ManagerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManagerService {
    @Value("http://localhost:9090")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Manager> getAllManager() {
        String url = apiHostUrl + ApiPath.MANAGER_GET_ALL;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ManagerDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<ManagerDTO>() {
                }
        );
        ManagerDTO managerDTO = responseEntity.getBody();

        return managerDTO.getList();
    }

    public Manager getById(String id) {
        String url = apiHostUrl + ApiPath.MANAGER_GET_ID + "?id=" + id;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ManagerDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<ManagerDTO>() {
                }
        );
        ManagerDTO managerDTO = responseEntity.getBody();

        return managerDTO.getData();
    }

    public Manager create(ManagerDTO managerDTO) {
        String url = apiHostUrl + ApiPath.MANAGER_CREATE;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ManagerDTO> entity = new HttpEntity<>(managerDTO, headers);

        ResponseEntity<Manager> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                Manager.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }


    public Manager update(ManagerDTO managerDTO) {
        String url = apiHostUrl + ApiPath.MANAGER_UPDATE;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ManagerDTO> entity = new HttpEntity<>(managerDTO, headers);

        ResponseEntity<Manager> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                entity,
                Manager.class
        );
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return null;
        }

    }


    public boolean delete(String uuid) {
        String url = apiHostUrl + ApiPath.MANAGER_DELETE + "?uuid" + uuid;
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

    public ManagerDTO signIn(String username, String password) {
        String url = apiHostUrl + ApiPath.MANAGER_SIGN_IN;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create a request body with the username and password
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", username);
        requestBody.put("password", password);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<ManagerDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                ManagerDTO.class
        );
        return responseEntity.getBody();
    }
    public ManagerDTO getManagerByUsername(String username) {
        String url = apiHostUrl + ApiPath.MANAGER_GET_BY_USERNAME + "?username=" + username;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ManagerDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<ManagerDTO>() {}
        );
        return responseEntity.getBody();
    }

}
