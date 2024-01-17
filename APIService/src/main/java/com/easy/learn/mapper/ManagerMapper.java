package com.easy.learn.mapper;

import com.easy.learn.dto.ManagerDTO;
import com.easy.learn.entity.Manager;
import org.springframework.stereotype.Service;

@Service
public class ManagerMapper extends AbstractMapper<Manager , ManagerDTO> {
    public ManagerMapper(){
        super(Manager.class,ManagerDTO.class);
    }
}
