package com.edu.zjut.controller;

import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.ResUsr;
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
    public Res adminauthorization(HttpServletRequest request){
        String mid=(String) request.getSession().getAttribute("mid");
        if (mid == null || mid.equals("") || mid.equals(null))
            return new Res("未登录管理员账号", 500);
        else
            return new Res("已登录管理员账号", 200);
    }
}
