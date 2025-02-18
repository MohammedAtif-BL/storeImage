package com.bridgelabz.practice.service;

import com.bridgelabz.practice.entity.Image;
import com.bridgelabz.practice.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MyService {
    private final MyRepository repository;

    public Image addImage(MultipartFile image) throws IOException {
        Image imageData = new Image();
        imageData.setImageName(image.getOriginalFilename());
        imageData.setImageType(image.getContentType());

        return repository.save(imageData);
    }
}
