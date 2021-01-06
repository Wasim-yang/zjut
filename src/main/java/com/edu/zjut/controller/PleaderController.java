package com.edu.zjut.controller;

import com.edu.zjut.entity.ResPleader;
import com.edu.zjut.service.PleaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PleaderController {
    PleaderService pleaderService;

    @Autowired
    public void setPleaderService(PleaderService pleaderService) {
        this.pleaderService = pleaderService;
    }

    /*项目负责人登录*/
    @RequestMapping(path = "/pleader/login")
    public ResPleader login(String id, String password, HttpServletRequest request){
        ResPleader resPleader=pleaderService.login(id,password);
        if(resPleader.getCode()==200){
            request.getSession().setAttribute("pid",resPleader.getPid());
            return new ResPleader("登录成功",200,resPleader.getPid());
        }
        else {
            return new ResPleader("登录失败",500,null);
        }
    }

}
