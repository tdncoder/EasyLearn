package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.UserDTO;
import com.easy.learn.response.UserResponseDTO;
import com.easy.learn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j

public class UserController {
    @Autowired
    UserService service;

    @GetMapping(value = ApiPath.USER_GET_ALL)
    public ResponseEntity<UserResponseDTO> getAllUsers() {
        UserResponseDTO response = new UserResponseDTO();
        try {
            List<UserDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success get all users");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when get all users:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping(value = ApiPath.USER_SIGN_IN)
//    public ResponseEntity<UserResponseDTO> signIn(@RequestBody UserDTO request) {
//        UserResponseDTO response = new UserResponseDTO();
//        try {
//            UserDTO user = service.login(request.getUserName(), request.getPassword());
//            if (user != null && user.getId() != null) {
//                response.setData(user);
//                response.setMessage("Success sign in");
//                response.setErrorCode(200);
//                return new ResponseEntity<>(response, HttpStatus.OK);
//            }
//            response.setMessage("UserName or password incorrect!!");
//            response.setErrorCode(400);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            response.setMessage("Error when signIn:" + e);
//            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    // end
}
