package com.easy.learn.web.callApi;


import com.easy.learn.web.consts.ApiPath;
import com.easy.learn.web.dto.user.User;
import com.easy.learn.web.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserCallService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<User> getAllUser() {
        //Init variables
        String url = apiHostUrl+ ApiPath.USER_GET_ALL;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<UserDTO> userResponse = restTemplate.exchange(url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<UserDTO>() {});
        UserDTO userDTO = userResponse.getBody();
        return userDTO.getList();
    }


    public UserDTO signIn(String username, String password) {
        String url = apiHostUrl + ApiPath.USER_SIGN_IN;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create a request body with the username and password
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", username);
        requestBody.put("password", password);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                UserDTO.class
        );
        return responseEntity.getBody();
    }
    public UserDTO getUserByUsername(String username) {
        String url = apiHostUrl + ApiPath.USER_GET_BY_USERNAME + "?username=" + username;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<UserDTO>() {}
        );
        return responseEntity.getBody();
    }
    public User create(UserDTO userDTO) {
        String url = apiHostUrl + ApiPath.USER_CREATE;
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserDTO> entity = new HttpEntity<>(userDTO, headers);

        ResponseEntity<User> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                User.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }
}
