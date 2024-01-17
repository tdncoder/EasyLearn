package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.WebsiteFinancesSummaryDTO;
import com.easy.learn.entity.WebsiteFinancesSummary;
import com.easy.learn.response.WebsiteFinancesSummaryResponseDTO;
import com.easy.learn.service.WebsiteFinancesSummaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class WebsiteFinancesSummaryController {
    @Autowired
    WebsiteFinancesSummaryService service;


    @GetMapping(value = ApiPath.WEBSITE_FINANCES_SUMMARY_GET_ALL)
    public ResponseEntity<WebsiteFinancesSummaryResponseDTO> getAllTWebsiteFinancesSummary() {
        WebsiteFinancesSummaryResponseDTO response = new WebsiteFinancesSummaryResponseDTO();

        try {
            List<WebsiteFinancesSummaryDTO> list = service.findAll();
            response.setList(list);
            response.setMessage("Success get all Website Finances Summary records");
            response.setErrorCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error when getting all Website Finances Summary records", e);
            response.setMessage("Error when getting all Website Finances Summary records: " + e.getMessage());
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.WEBSITE_FINANCES_SUMMARY_GET_ONE)
        public ResponseEntity<WebsiteFinancesSummaryResponseDTO> getWebsiteFinancesSummaryById(@RequestParam Long id) {
            WebsiteFinancesSummaryResponseDTO response = new WebsiteFinancesSummaryResponseDTO();

            try {
                WebsiteFinancesSummaryDTO dto = service.findById(id);
                response.setData(dto);
                response.setMessage("Success get Website Finances Summary record by ID");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Error when getting Website Finances Summary record by ID", e);
                response.setMessage("Error when getting Website Finances Summary record by ID: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @PostMapping(value = ApiPath.WEBSITE_FINANCES_SUMMARY_CREATE)
        public ResponseEntity<WebsiteFinancesSummaryResponseDTO> createWebsiteFinancesSummary(@RequestBody WebsiteFinancesSummaryDTO dto) {
            WebsiteFinancesSummaryResponseDTO response = new WebsiteFinancesSummaryResponseDTO();

            try {
                WebsiteFinancesSummaryDTO createdDto = service.create(dto);
                response.setData(createdDto);
                response.setMessage("Success creating Website Finances Summary record");
                response.setErrorCode(HttpStatus.CREATED.value());
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Error when creating Website Finances Summary record", e);
                response.setMessage("Error when creating trainer salary record: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PutMapping(value = ApiPath.WEBSITE_FINANCES_SUMMARY_UPDATE)
        public ResponseEntity<WebsiteFinancesSummaryResponseDTO> updateWebsiteFinancesSummary(@RequestBody WebsiteFinancesSummaryDTO dto) {
            WebsiteFinancesSummaryResponseDTO response = new WebsiteFinancesSummaryResponseDTO();

            try {
                boolean updated = service.update(dto);
                if (updated) {
                    response.setMessage("Success updating Website Finances Summary record");
                    response.setErrorCode(HttpStatus.OK.value());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.setMessage("Trainer Website Finances Summary not found");
                    response.setErrorCode(HttpStatus.NOT_FOUND.value());
                    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                log.error("Error when updating Website Finances Summary record", e);
                response.setMessage("Error when updating Website Finances Summary record: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @DeleteMapping(value = ApiPath.WEBSITE_FINANCES_SUMMARY_DELETE)
            public ResponseEntity<WebsiteFinancesSummaryResponseDTO> deleteWebsiteFinancesSummary(@RequestParam Long id) {
                WebsiteFinancesSummaryResponseDTO response = new WebsiteFinancesSummaryResponseDTO();

                try {
                    boolean deleted = service.delete(id);
                    if (deleted) {
                        response.setMessage("Success deleting Website Finances Summary record");
                        response.setErrorCode(HttpStatus.OK.value());
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    } else {
                        response.setMessage("TWebsite Finances Summary record not found");
                        response.setErrorCode(HttpStatus.NOT_FOUND.value());
                        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                    }
                } catch (Exception e) {
                    log.error("Error when deleting Website Finances Summary record", e);
                    response.setMessage("Error when deleting Website Finances Summary record: " + e.getMessage());
                    response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
}
