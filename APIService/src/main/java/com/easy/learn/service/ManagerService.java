package com.easy.learn.service;

import com.easy.learn.dto.ManagerDTO;
import com.easy.learn.entity.Manager;

public interface ManagerService extends BaseService<ManagerDTO>{

    ManagerDTO login(String username, String password);
    ManagerDTO findByUuid(String uuid);
    ManagerDTO getByUsername(String username);

    ManagerDTO getById(Long id);

}
