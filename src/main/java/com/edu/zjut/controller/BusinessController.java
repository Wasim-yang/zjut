package com.edu.zjut.controller;

import com.edu.zjut.entity.Res;
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

    /*商家——登录*/
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

    /*商家——登出*/
    @RequestMapping(path = "/business/logout")
    public Res logout(HttpServletRequest request){
        request.getSession().removeAttribute("bid");
        if(request.getSession().getAttribute("bid") == null)
            return new Res("登出成功",200);
        else
            return new Res("登出失败",500);
    }

}
