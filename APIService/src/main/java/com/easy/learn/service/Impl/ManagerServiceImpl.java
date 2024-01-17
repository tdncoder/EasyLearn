package com.easy.learn.service.Impl;

import com.easy.learn.dto.ManagerDTO;
import com.easy.learn.mapper.ManagerMapper;
import com.easy.learn.entity.Manager;
import com.easy.learn.repository.ManagerRepository;
import com.easy.learn.service.ManagerService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepository repository;

    @Autowired
    ManagerMapper mapper;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public ManagerDTO create(ManagerDTO managerDTO) {
        ManagerDTO result = new ManagerDTO();
        try {
            Manager manager = mapper.convertDTOToEntity(managerDTO);
            result =mapper.convertEntityToDTO(repository.saveAndFlush(manager));
        } catch (Exception ex) {
            log.error("Error when creating:", ex);
        }

        return result;
    }

    @Override
    public boolean update(ManagerDTO dto) {
        try {
            Manager manager = mapper.convertDTOToEntity(dto);
            mapper.convertEntityToDTO(repository.saveAndFlush(manager));
            return true;
        } catch (Exception ex) {
            log.error("Error when updating:", ex);
            return false;
        }
    }

    @Override
    public List<ManagerDTO> findAll() {
        List<Manager> managers = repository.findAll();
        return managers == null ? new ArrayList<>()
                : managers.stream().map(entity -> mapper.convertEntityToDTO(entity))
                .collect(Collectors.toList());
    }



    @Override
    public ManagerDTO findByUuid(String uuid) {
        Manager manager = repository.findByUuid(uuid);
        return manager != null ? mapper.convertEntityToDTO(manager) : null;
    }

    @Override
    public ManagerDTO getByUsername(String username) {
        Manager manager = repository.findByUsername(username);
        return manager != null ? mapper.convertEntityToDTO(manager) : null;
    }


    @Override
    public ManagerDTO getById(Long id) {
        try {
            Manager manager = repository.findById(id).orElse(null);
            if (manager != null) {
                return mapper.convertEntityToDTO(manager);
            } else {
                throw new NotFoundException("Manager not found");
            }
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean delete(Long id) {
        Manager manager = repository.findById(id).get();
        if (manager != null) {
            repository.delete(manager);
            return true;
        }
        return false;
    }
    @Override
    public ManagerDTO login(String username, String password) {
        Manager manager = repository.findByUserNameAndPassword(username, password);
       return mapper.convertEntityToDTO(manager);
    }

}
