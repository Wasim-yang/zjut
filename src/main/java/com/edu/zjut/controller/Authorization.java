package com.edu.zjut.controller;

import com.edu.zjut.entity.ResUsr;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Authorization {

    @RequestMapping(path = "/usr/authorization")
    public ResUsr usrauthorization(HttpServletRequest request) {
        System.out.println(request.getSession().getId());
        String uid = (String) request.getSession().getAttribute("uid");
        System.out.println(uid);
        if (uid == null || uid.equals("") || uid.equals(null))
            return new ResUsr("未登录", 500, null);
        else
            return new ResUsr("已登录", 200, uid);
    }
}
