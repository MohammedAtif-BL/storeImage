package com.bridgelabz.practice.controller;

import com.bridgelabz.practice.entity.Image;
import com.bridgelabz.practice.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private MyService myService;

    @PostMapping
    public ResponseEntity<?> addImage(@RequestPart MultipartFile image) throws IOException {
        Image image1 = myService.addImage(image);
        return new ResponseEntity<>(image1, HttpStatus.CREATED);
    }
}
