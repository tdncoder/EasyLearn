package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import com.easy.learn.dto.WebsiteVenueDTO;
import com.easy.learn.response.WebsiteVenueResponseDTO;
import com.easy.learn.service.WebsiteVenueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class WebsiteVenueController {
    @Autowired
    WebsiteVenueService service;;

    @GetMapping(value = ApiPath.WEBSITE_VENUE_GET_ALL)
        public ResponseEntity<WebsiteVenueResponseDTO> getAllWebsiteVenue() {
            WebsiteVenueResponseDTO response = new WebsiteVenueResponseDTO();

            try {
                List<WebsiteVenueDTO> list = service.findAll();
                response.setList(list);
                response.setMessage("Success get all Website Venue records");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Error when getting all trainer salary records", e);
                response.setMessage("Error when getting all Website Venue records: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @GetMapping(value = ApiPath.WEBSITE_VENUE_GET_ONE)
        public ResponseEntity<WebsiteVenueResponseDTO> getWebsiteVenueById(@RequestParam Long id) {
            WebsiteVenueResponseDTO response = new WebsiteVenueResponseDTO();

            try {
                WebsiteVenueDTO dto = service.findById(id);
                response.setData(dto);
                response.setMessage("Success get Website Venue records by ID");
                response.setErrorCode(HttpStatus.OK.value());
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Error when getting Website Venue records by ID", e);
                response.setMessage("Error when getting Website Venue records by ID: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PostMapping(value = ApiPath.WEBSITE_VENUE_CREATE)
        public ResponseEntity<WebsiteVenueResponseDTO> createWebsiteVenue(@RequestBody WebsiteVenueDTO dto) {
            WebsiteVenueResponseDTO response = new WebsiteVenueResponseDTO();

            try {
                WebsiteVenueDTO createdDto = service.create(dto);
                response.setData(createdDto);
                response.setMessage("Success creating Website Venue records");
                response.setErrorCode(HttpStatus.CREATED.value());
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } catch (Exception e) {
                log.error("Error when creating Website Venue records", e);
                response.setMessage("Error when creating Website Venue records: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @PutMapping(value = ApiPath.WEBSITE_VENUE_UPDATE)
        public ResponseEntity<WebsiteVenueResponseDTO> updateWebsiteVenue(@RequestBody WebsiteVenueDTO dto) {
            WebsiteVenueResponseDTO response = new WebsiteVenueResponseDTO();

            try {
                boolean updated = service.update(dto);
                if (updated) {
                    response.setMessage("Success updating Website Venue records");
                    response.setErrorCode(HttpStatus.OK.value());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.setMessage("Website Venue records not found");
                    response.setErrorCode(HttpStatus.NOT_FOUND.value());
                    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                log.error("Error when updating Website Venue records", e);
                response.setMessage("Error when updating Website Venue records: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @DeleteMapping(value = ApiPath.WEBSITE_VENUE_DELETE)
        public ResponseEntity<WebsiteVenueResponseDTO> deleteWebsiteVenue(@RequestParam Long id) {
            WebsiteVenueResponseDTO response = new WebsiteVenueResponseDTO();

            try {
                boolean deleted = service.delete(id);
                if (deleted) {
                    response.setMessage("Success deleting Website Venue records");
                    response.setErrorCode(HttpStatus.OK.value());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.setMessage("Website Venue records not found");
                    response.setErrorCode(HttpStatus.NOT_FOUND.value());
                    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                log.error("Error when deleting Website Venue records", e);
                response.setMessage("Error when deleting Website Venue records: " + e.getMessage());
                response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
