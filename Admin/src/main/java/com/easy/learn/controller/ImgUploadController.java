package com.easy.learn.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImgUploadController {
    @RequestMapping(value = "getImg/{courseEditImg}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImg(@PathVariable("courseEditImg")String courseEditImg){
        if(!courseEditImg.equals("") || courseEditImg != null){
            try{
                Path fileName = Paths.get("src/main/resources/static/img/course",courseEditImg);
                byte[] buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/png"))
                        .body(byteArrayResource);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
