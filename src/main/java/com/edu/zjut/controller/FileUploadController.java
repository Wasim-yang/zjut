package com.edu.zjut.controller;

import com.edu.zjut.service.FilePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    @Autowired
    private FilePathService filePathService;

    @PostMapping("/upload")
    String upload(@RequestParam("upload") MultipartFile file) {
        return filePathService.Upload(file);
    }

    @PostMapping("/upload/update")
    String update(@RequestParam("upload") MultipartFile file,@RequestParam("originpath") String originpath ){
        return filePathService.update(file, originpath);
    }
}
