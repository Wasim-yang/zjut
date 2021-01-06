package com.edu.zjut.controller;

import com.edu.zjut.entity.Res;
import com.edu.zjut.service.TravellogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TravellogController {
    TravellogService travellogService;

    @Autowired
    public void setTravellogService(TravellogService travellogService) {
        this.travellogService = travellogService;
    }

    /*用户出行里程记录添加*/
    @RequestMapping(path = "usr/inserttravel")
    public Res insert(String uid, int type, float mileage) {
        return travellogService.insert(uid, type, mileage);
    }
}
