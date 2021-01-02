package com.edu.zjut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ZjutApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjutApplication.class, args);
    }

}
