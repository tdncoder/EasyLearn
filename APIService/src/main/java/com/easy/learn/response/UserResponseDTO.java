package com.easy.learn.response;

import com.easy.learn.dto.UserDTO;
import lombok.Data;

@Data
public class UserResponseDTO extends ResponseDTO<UserDTO> {
    private String accessToken;
    private String tokenType;
}
