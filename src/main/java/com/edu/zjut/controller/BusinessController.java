package com.edu.zjut.controller;

import com.edu.zjut.entity.ResBusiness;
import com.edu.zjut.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BusinessController {
    BusinessService businessService;

    @Autowired
    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

    /*商家登录*/
    @RequestMapping(path = "/business/login")
    public ResBusiness login(String id, String password, HttpServletRequest request){
        ResBusiness resBusiness=businessService.login(id,password);
        if(resBusiness.getCode() == 200){
            request.getSession().setAttribute("bid",resBusiness.getBid());
            return new ResBusiness("登录成功",200,resBusiness.getBid());
        }
        else {
            return new ResBusiness("登录失败",500,null);
        }
    }

}
