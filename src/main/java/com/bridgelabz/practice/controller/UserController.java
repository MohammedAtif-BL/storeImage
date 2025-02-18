package com.bridgelabz.practice.controller;

import com.bridgelabz.practice.entity.Image;
import com.bridgelabz.practice.entity.User;
import com.bridgelabz.practice.service.MyService;
import com.bridgelabz.practice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MyService myService;

        @PostMapping(value = "/addUserWithImage",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<?> addUserWithImage(
                @RequestPart("user") String userJson,
                @RequestPart("image") MultipartFile image) throws IOException {

            // Convert userJson to User object
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(userJson, User.class);

            // Save the image
            Image savedImage = myService.addImage(image);

            // Associate the image with the user
            user.setProfileImage(savedImage);

            // Save the user
            User savedUser = userService.addUser(user);

            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }

}
