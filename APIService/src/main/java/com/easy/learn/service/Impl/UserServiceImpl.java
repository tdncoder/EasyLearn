package com.easy.learn.service.Impl;

import com.easy.learn.dto.UserDTO;
import com.easy.learn.entity.User;
import com.easy.learn.mapper.UserMapper;
import com.easy.learn.repository.UserRepository;
import com.easy.learn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;

    @Override
    public UserDTO create(UserDTO dto) {
        UserDTO result = new UserDTO();
        try {
            User user = mapper.convertDTOToEntity(dto);
            result = mapper.convertEntityToDTO(repository.saveAndFlush(user));
        } catch (Exception ex) {
            log.error("Error when creating:", ex);
        }

        return result;
    }

    @Override
    public boolean update(UserDTO dto) {
        try {
            User user = mapper.convertDTOToEntity(dto);
            mapper.convertEntityToDTO(repository.saveAndFlush(user));
            return true;
        } catch (Exception ex) {
            log.error("Error when updating:", ex);
            return false;
        }
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        return users == null ? new ArrayList<>()
                : users.stream().map(entity -> mapper.convertEntityToDTO(entity))
                                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(Long id) {
        User user = repository.findById(id).get();
        if (user != null) {
            repository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public UserDTO login(String name, String password) {
        User user = repository.findByUserNameAndPassword(name, password);
        return user == null ?  null : mapper.convertEntityToDTO(user);
    }
}
