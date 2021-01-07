package com.edu.zjut.controller;

import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.Userlogin;
import com.edu.zjut.service.UsrManageService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/7 14:46
 * @description ：
 */
@RestController
public class UsrManageController {
    @Autowired
    UsrManageService usrManageService;
    /*个人中心*/
    @RequestMapping(path = "/usr/topupMoney")
    public Res topupMoney (String uid){
        return usrManageService.topupMoney(uid);
    }
    @RequestMapping(path = "/usr/selectAll")
    public Userlogin selectAll (String uid){
        return usrManageService.selectAll(uid);
    }
}
