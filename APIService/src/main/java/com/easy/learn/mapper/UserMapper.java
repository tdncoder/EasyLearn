package com.easy.learn.mapper;

import com.easy.learn.dto.UserDTO;
import com.easy.learn.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper extends AbstractMapper<User, UserDTO> {
    public UserMapper() {
        super(User.class, UserDTO.class);
    }
}
