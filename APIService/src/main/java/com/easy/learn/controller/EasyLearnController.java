package com.easy.learn.controller;

import com.easy.learn.consts.ApiPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EasyLearnController {

    @GetMapping(value = ApiPath.PING)
    public String ping() {
        return "start easy learn!!!!";
    }
}
