package com.easy.learn.service;

import com.easy.learn.dto.UserDTO;

public interface UserService extends  BaseService<UserDTO> {
    UserDTO login(String name, String password);
}
