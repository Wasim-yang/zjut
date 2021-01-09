package com.edu.zjut.controller;

import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.Userlogin;
import com.edu.zjut.service.UsrManageService;
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
    public Res topupMoney(String uid) {
        return usrManageService.topupMoney(uid);
    }

    @RequestMapping(path = "/usr/selectAll")
    public Userlogin selectAll(String uid) {
        return usrManageService.selectAll(uid);
    }

    /*获取优惠券个数*/
    @RequestMapping(path = "/usr/getCouponNum")
    public int getCouponNum(String uid) {
        return usrManageService.getCouponNum(uid);
    }

    @RequestMapping(path = "/usr/info/updateName")
    public Res updateName(String uid, String uname) {
        return usrManageService.updateName(uid, uname);
    }

    @RequestMapping(path = "/usr/info/updateSex")
    public Res updateSex(String uid, String usex) {
        return usrManageService.updateSex(uid, usex);
    }

    @RequestMapping(path = "/usr/info/updateAge")
    public Res updateAge(String uid, String uage) {
        return usrManageService.updateAge(uid, uage);
    }

    @RequestMapping(path = "/usr/info/updateAddr")
    public Res updateAddress(String uid, String uaddr) {
        return usrManageService.updateAddress(uid, uaddr);
    }

    @RequestMapping(path = "/usr/info/updatePassword")
    public Res updatePassword(String uid, String upassword) {
        return usrManageService.updatePassword(uid, upassword);
    }

    @RequestMapping(path = "/usr/deleteUsr")
    public Res updatePassword(String uid) {
        return usrManageService.deleteUsr(uid);
    }

}
