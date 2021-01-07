package com.edu.zjut.controller;

import com.edu.zjut.entity.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Authorization {

    @RequestMapping(path = "/usr/authorization")
    public ResUsr usrauthorization(HttpServletRequest request) {
        String uid = (String) request.getSession().getAttribute("uid");
        if (uid == null || uid.equals("") || uid.equals(null))
            return new ResUsr("未登录用户账号", 500, null);
        else
            return new ResUsr("已登录用户账号", 200, uid);
    }

    @RequestMapping(path = "/admin/authorization")
    public ResManager adminauthorization(HttpServletRequest request){
        String mid=(String) request.getSession().getAttribute("mid");
        if (mid == null || mid.equals("") || mid.equals(null))
            return new ResManager("未登录管理员账号", 500,null);
        else
            return new ResManager("已登录管理员账号", 200,mid);
    }
    
    @RequestMapping(path = "/business/authorization")
    public ResBusiness businessauthorization(HttpServletRequest request){
        String bid=(String) request.getSession().getAttribute("bid");
        if (bid == null || bid.equals("") || bid.equals(null))
            return new ResBusiness("未登录商家账号", 500,null);
        else
            return new ResBusiness("已登录商家账号", 200, bid);
    }
    @RequestMapping(path = "/pleader/authorization")
    public ResPleader pleaderauthorization(HttpServletRequest request){
        String pid=(String) request.getSession().getAttribute("pid");
        if (pid == null || pid.equals("") || pid.equals(null))
            return new ResPleader("未登录项目负责人账号", 500,null);
        else
            return new ResPleader("已登录项目负责人账号", 200,pid);
    }
}
