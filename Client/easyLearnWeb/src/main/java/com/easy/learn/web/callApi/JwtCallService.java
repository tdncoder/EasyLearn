package com.easy.learn.web.callApi;

import com.easy.learn.web.consts.ApiPath;
import com.easy.learn.web.dto.authentication.AuthenticationRequest;
import com.easy.learn.web.dto.authentication.AuthenticationResponse;
import com.easy.learn.web.dto.authentication.AuthenticationResponseDTO;
import com.easy.learn.web.dto.authentication.RegisterRequest;
import com.easy.learn.web.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JwtCallService {
    @Value("${api.host.url}")
    String apiHostUrl;

    @Autowired
    RestTemplate restTemplate;

        public AuthenticationResponse getAuthenToken(AuthenticationRequest request) {
            String url = apiHostUrl + ApiPath.AUTHENTICATE;
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            HttpEntity<AuthenticationRequest> entity = new HttpEntity<>(request, headers);

            ResponseEntity<AuthenticationResponseDTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<AuthenticationResponseDTO>() {
                    });
            AuthenticationResponseDTO dto = response.getBody();

            return dto.getData();
        }
    public AuthenticationResponse registerUser(UserDTO request) {
            String url = apiHostUrl + ApiPath.REGISTER;
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            HttpEntity<UserDTO> entity = new HttpEntity<>(request,headers);
            ResponseEntity<AuthenticationResponseDTO> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<AuthenticationResponseDTO>() {
                    }
            );
        AuthenticationResponseDTO dto = response.getBody();

        if (response.getStatusCode() == HttpStatus.OK) {
            return dto.getData();
        } else {
            // Handle the error case
            // You might want to throw an exception or return null, depending on your use case
            return null;
        }

    }


}
