package com.easy.learn.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class VideoUploadController {

    @RequestMapping(value = "getVideo/{videoFileName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getVideo(@PathVariable("videoFileName") String videoFileName) {
        if (!videoFileName.equals("") || videoFileName != null) {
            try {
                Path filePath = Paths.get("src/main/resources/static/videos/lesson", videoFileName);
                byte[] videoBytes = Files.readAllBytes(filePath);
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("video/mp4"))
                        .body(videoBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.badRequest().build();
    }
}


