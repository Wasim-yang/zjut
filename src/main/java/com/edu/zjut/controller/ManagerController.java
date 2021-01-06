package com.edu.zjut.controller;

import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.ResManager;
import com.edu.zjut.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ManagerController {
    ManagerService managerService;

    @Autowired
    public void setManagerService(ManagerService managerService){this.managerService=managerService;}

    /*管理员——登录*/
    @RequestMapping(path = "/admin/login")
    public ResManager login(String id, String password, HttpServletRequest request){
        ResManager resManager=managerService.login(id,password);
        if(resManager.getCode()==200){
            request.getSession().setAttribute("mid",resManager.getMid());
            return new ResManager("登录成功",200,resManager.getMid());
        }
        else {
            return new ResManager("登录失败",500,null);
        }
    }

    /*管理员——登出*/
    @RequestMapping(path = "/admin/logout")
    public Res logout(HttpServletRequest request){
        request.getSession().removeAttribute("mid");
        if(request.getSession().getAttribute("mid") == null)
            return new Res("登出成功",200);
        else
            return new Res("登出失败",500);
    }

}
