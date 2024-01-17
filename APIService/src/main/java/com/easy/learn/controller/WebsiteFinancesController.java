package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.WebsiteFinancesDTO;
import com.easy.learn.response.WebsiteFinancesResponseDTO;
import com.easy.learn.service.WebsiteFinancesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class WebsiteFinancesController {
    @Autowired
    WebsiteFinancesService service;
    @GetMapping(value = ApiPath.WEBSITE_FINANCES_GET_ALL)
        public ResponseEntity<WebsiteFinancesResponseDTO> getAllWebsiteFinances() {
            WebsiteFinancesResponseDTO response = new WebsiteFinancesResponseDTO();

            try {
                List<WebsiteFinancesDTO> list = service.findAll();
                response.setList(list);
                response.setMessage("Success get all Website Finances records");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Error when getting all Website Finances records", e);
                response.setMessage("Error when getting all tWebsite Finances records: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @GetMapping(value = ApiPath.WEBSITE_FINANCES_GET_ONE)
        public ResponseEntity<WebsiteFinancesResponseDTO> getWebsiteFinancesById(@RequestParam Long id) {
            WebsiteFinancesResponseDTO response = new WebsiteFinancesResponseDTO();

            try {
                WebsiteFinancesDTO dto = service.findById(id);
                response.setData(dto);
                response.setMessage("Success get Website Finances record by ID");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Error when getting Website Finances record by ID", e);
                response.setMessage("Error when getting Website Finances record by ID: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PostMapping(value = ApiPath.WEBSITE_FINANCES_CREATE)
        public ResponseEntity<WebsiteFinancesResponseDTO> createWebsiteFinances(@RequestBody WebsiteFinancesDTO dto) {
             WebsiteFinancesResponseDTO response = new  WebsiteFinancesResponseDTO();

            try {
                WebsiteFinancesDTO createdDto = service.create(dto);
                response.setData(createdDto);
                response.setMessage("Success creating Website Finances record");
                response.setErrorCode(HttpStatus.CREATED.value());
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Error when creating Website Finances record", e);
                response.setMessage("Error when creating Website Finances record: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PutMapping(value = ApiPath.WEBSITE_FINANCES_UPDATE)
        public ResponseEntity<WebsiteFinancesResponseDTO> updateWebsiteFinances(@RequestBody WebsiteFinancesDTO dto) {
            WebsiteFinancesResponseDTO response = new WebsiteFinancesResponseDTO();

            try {
                boolean updated = service.update(dto);
                if (updated) {
                    response.setMessage("Success updating Website Finances record");
                    response.setErrorCode(HttpStatus.OK.value());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.setMessage("Website Finances record not found");
                    response.setErrorCode(HttpStatus.NOT_FOUND.value());
                    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                log.error("Error when updating Website Finances record", e);
                response.setMessage("Error when updating Website Finances record: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @DeleteMapping(value = ApiPath.WEBSITE_FINANCES_DELETE)
        public ResponseEntity<WebsiteFinancesResponseDTO> deleteWebsiteFinances(@RequestParam Long id) {
            WebsiteFinancesResponseDTO response = new WebsiteFinancesResponseDTO();

            try {
                boolean deleted = service.delete(id);
                if (deleted) {
                    response.setMessage("Success deleting Website Finances record");
                    response.setErrorCode(HttpStatus.OK.value());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.setMessage("Website Finances record not found");
                    response.setErrorCode(HttpStatus.NOT_FOUND.value());
                    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                log.error("Error when deleting Website Finances record", e);
                response.setMessage("Error when deleting Website Finances record: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
