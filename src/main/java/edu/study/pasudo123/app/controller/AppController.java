package edu.study.pasudo123.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class AppController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/time")
    public String nowTime() {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return "time : " + LocalDateTime.now().format(format);
    }
}
