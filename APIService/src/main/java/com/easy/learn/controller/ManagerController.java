package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.ManagerDTO;
import com.easy.learn.response.ManagerResponseDTO;
import com.easy.learn.service.ManagerService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
public class ManagerController {
    @Autowired
    ManagerService service;

    @GetMapping(value = ApiPath.MANAGER_GET_ALL)
    public ResponseEntity<ManagerResponseDTO> getAllManagers() {
        ManagerResponseDTO response = new ManagerResponseDTO();
        try {
            List<ManagerDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success get all managers");
            response.setErrorCode(200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when get all managers:" + e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.MANAGER_SIGN_IN)
    public ResponseEntity<ManagerResponseDTO> signIn(@RequestBody ManagerDTO  managerDTO) {
        ManagerResponseDTO response = new ManagerResponseDTO();
        try {
            ManagerDTO login = service.login(managerDTO.getUsername(), managerDTO.getPassword());
            response.setMessage("Success sign in");
            response.setErrorCode(HttpStatus.OK.value());
            response.setData(login);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error when signIn:" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.MANAGER_GET_UUID)
    public ResponseEntity<ManagerResponseDTO> getByUuid(@RequestParam String uuid) {
        ManagerResponseDTO response = new ManagerResponseDTO();
        try{
            ManagerDTO managerDTO = service.findByUuid(uuid);
            if(managerDTO != null){
                response.setData(managerDTO);
                response.setMessage("Success get manager by UUID");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Manager not found");
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when getting manager by UUID: "+ e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = ApiPath.MANAGER_CREATE)
    public ResponseEntity<ManagerResponseDTO> createManager(@RequestBody ManagerDTO request) {
        ManagerResponseDTO response = new ManagerResponseDTO();
        try {
            ManagerDTO createdManager = service.create(request);
            response.setData(createdManager);
            response.setMessage("Manager created successfully");
            response.setErrorCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage("Error when creating manager: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping(value = ApiPath.MANAGER_UPDATE)
//    public ResponseEntity<ManagerResponseDTO> updateManager(@RequestBody ManagerDTO request) {
//        ManagerResponseDTO response = new ManagerResponseDTO();
//        try {
//            boolean updatedManager = service.update(request);
//            if (updatedManager) {
//                response.setMessage("Manager updated successfully");
//                response.setErrorCode(HttpStatus.OK.value());
//                return new ResponseEntity<>(response, HttpStatus.OK);
//            } else {
//                response.setMessage("Manager not found");
//                response.setErrorCode(HttpStatus.NOT_FOUND.value());
//                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            response.setMessage("Error when updating manager: " + e.getMessage());
//            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
@PutMapping(value = ApiPath.MANAGER_UPDATE)
public ResponseEntity<ManagerResponseDTO> updateManager(@RequestBody ManagerDTO request) {
    ManagerResponseDTO response = new ManagerResponseDTO();
    try {
        ManagerDTO existingManager = service.getById(request.getId());
        if (existingManager != null) {
            // Update the non-null fields of the existing manager with the values from the request
            if (request.getFirstname() != null) {
                existingManager.setFirstname(request.getFirstname());
            }
            if (request.getLastname() != null) {
                existingManager.setLastname(request.getLastname());
            }
            if (request.getEmail() != null) {
                existingManager.setEmail(request.getEmail());
            }
            if (request.getAddress() != null) {
                existingManager.setAddress(request.getAddress());
            }
            if (request.getPhone() != null) {
                existingManager.setPhone(request.getPhone());
            }


            // Update the manager in the service
            boolean updatedManager = service.update(existingManager);
            if (updatedManager) {
                response.setMessage("Manager updated successfully");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Manager not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } else {
            response.setMessage("Manager not found");
            response.setErrorCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    } catch (Exception e) {
        response.setMessage("Error when updating manager: " + e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @DeleteMapping(value = ApiPath.MANAGER_DELETE)
    public ResponseEntity<ManagerResponseDTO> deleteManager(@RequestParam Long uuid) {
        ManagerResponseDTO response = new ManagerResponseDTO();
        try {
            boolean deleted = service.delete(uuid);
            if (deleted) {
                response.setMessage("Manager deleted successfully");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Manager not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when deleting manager: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = ApiPath.MANAGER_GET_BY_USERNAME)
    public ResponseEntity<ManagerResponseDTO> getByUsername(@RequestParam String username) {
        ManagerResponseDTO response = new ManagerResponseDTO();
        try {
            ManagerDTO managerDTO = service.getByUsername(username);
            if (managerDTO != null) {
                response.setData(managerDTO);
                response.setMessage("Success get manager by username");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Manager not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when getting manager by username: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.MANAGER_GET_BY_ID)
    public ResponseEntity<ManagerResponseDTO> getById(@PathVariable Long id) {
        ManagerResponseDTO response = new ManagerResponseDTO();
        try {
            ManagerDTO managerDTO = service.getById(id);
            if (managerDTO != null) {
                response.setData(managerDTO);
                response.setMessage("Success get manager by ID");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Manager not found");
                response.setErrorCode(HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMessage("Error when getting manager by ID: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
