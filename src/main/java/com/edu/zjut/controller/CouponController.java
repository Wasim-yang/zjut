package com.edu.zjut.controller;
import com.edu.zjut.entity.Coupon;
import com.edu.zjut.entity.Res;
import com.edu.zjut.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CouponController {
    CouponService couponService;

    @Autowired
    public void setCouponService(CouponService couponService) {
        this.couponService = couponService;
    }
    /*添加*/
    @RequestMapping(path = "/coupon/insert")
    public Res insert(String name, float discount , int expoints ,  String description) {
        return couponService.insert(name, discount , expoints ,description);
    }
    /*查询*/
    @RequestMapping(path = "/coupon/select")
    public ArrayList<Coupon> select(){ return couponService.select();}

    /*按id查询*/
    @RequestMapping(path="coupon/selectid")
    public Coupon selectid(int id){return couponService.selectid(id);}

    /*删除*/
    @RequestMapping(path = "/coupon/delete")
    public Res delete(int id){ return couponService.delete(id); }

    /*更新*/
    @RequestMapping(path = "/coupon/update")
    public Res update(int id, String name, float discount , int expoints ,String description){
        return couponService.update(id, name, discount, expoints, description);
    }
}
