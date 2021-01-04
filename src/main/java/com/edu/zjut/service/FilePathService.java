package com.edu.zjut.service;

import java.io.IOException;
import java.util.Random;

import com.edu.zjut.entity.FilePath;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.edu.zjut.util.FileUtil;

@Service
public class FilePathService {

    public String Upload(@RequestParam("upload") MultipartFile file) {
        if (!file.isEmpty()) {
            /*获取文件名(含后缀)*/
            String fileName = file.getOriginalFilename();
            /*生成16位随机码*/
            String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<16;i++){
                int number=random.nextInt(62);
                sb.append(str.charAt(number));
            }
            String newstring = sb.toString();
            fileName = newstring+fileName;

            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
            try {
                /*文件写入封装*/
                FileUtil.fileupload(file.getBytes(),path,fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            FilePath biaopath = new FilePath();
            biaopath.setPath("http://localhost:8080/" + fileName);
            return biaopath.getPath();
        } else
            return null;
    }

    public String update(@RequestParam("upload") MultipartFile file,@RequestParam("originpath") String originpath){
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();

            /*生成16位随机码*/
            String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<16;i++){
                int number=random.nextInt(62);
                sb.append(str.charAt(number));
            }
            String newstring=sb.toString();
            fileName=newstring+fileName;

            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
            try {
                originpath=originpath.replace("http://localhost:8080/","");
                /*删除文件*/
                FileUtil.deletefile(path,originpath);
                FileUtil.fileupload(file.getBytes(),path,fileName);
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

