package com.edu.zjut.service;

import java.io.IOException;

import com.edu.zjut.entity.FilePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.edu.zjut.util.FileUtil;

@Service
public class FilePathService {

    public String Upload(@RequestParam("upload") MultipartFile file) {
        if (!file.isEmpty()) {

            String fileName = file.getOriginalFilename();

            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
            System.out.println(path);
            System.out.println(fileName);
            System.out.println(path+fileName);
            try {

                FileUtil.fileupload(file.getBytes(), path, fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            FilePath biaopath = new FilePath();
            biaopath.setPath("http://localhost:8080/" + fileName);
            return biaopath.getPath();
        } else
            return null;
    }
}

