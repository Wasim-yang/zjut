package com.edu.zjut.controller;

import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.ResUsr;
import com.edu.zjut.entity.UsrNoP;
import com.edu.zjut.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UsrController {
    UsrService usrService;

    @Autowired
    public void setUsrService(UsrService usrService) { this.usrService = usrService; }

    /*用户——登录*/
    @RequestMapping(path = "/usr/login")
    public Res login(String id, String password, HttpServletRequest request){
        ResUsr resUsr= usrService.login(id,password);
        if(resUsr.getCode()==200){
            request.getSession().setAttribute("uid",resUsr.getUid());
        }
        return new Res(resUsr.getMessage(),resUsr.getCode());
    }

    /*用户——注册*/
    @RequestMapping(path = "/usr/register")
    public Res register(String id, String password){
        return usrService.register(id,password);
    }
    /*添加*/
//    @RequestMapping(path = "/usr/insert")
//    public Res insert(String id,String name, String password, int sex, int age, String address, int cintegral) {
//        return usrService.insert(id, name, password, sex, age, address, cintegral);
//    }
    /*管理员——查询,输出无密码用户信息*/
    @RequestMapping(path = "/admin/usr/selectNoPpage")
    public Page<UsrNoP> admin_selectNoP(int currentPage){ return usrService.selectNoP(currentPage); }

    /*管理员——按id查询,输出无密码用户信息*/
    @RequestMapping(path = "/admin/usr/selectNoPid")
    public UsrNoP admin_selectNoPid(String id){return usrService.selectNoPid(id);}

    /*管理员——删除用户信息*/
    @RequestMapping(path = "/admin/usr/delete")
    public Res admin_delete(String id){ return usrService.delete(id); }

    /*管理员——更新用户信息*/
    @RequestMapping(path = "/admin/usr/updateNoP")
    public Res admin_updateNoP(String id, String name, int sex, int age, String address, int cintegral){
        return usrService.updateNoP(id, name, sex, age, address, cintegral);
    }

    /*用户——点击按钮获取用户碳积分信息*/
    @RequestMapping(path = "/user/usr/selectUsrUcintegral")
    public int selectUsrUcintegral(String uid){
        return usrService.selectUsrUcintegral(uid);
    }

}
