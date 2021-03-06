package com.edu.zjut.controller;

import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.*;
import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.ResUsr;
import com.edu.zjut.entity.UsrNoP;
import com.edu.zjut.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UsrController {
    UsrService usrService;

    /*处理表单日期数据导入异常*/
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    @Autowired
    public void setUsrService(UsrService usrService) {
        this.usrService = usrService;
    }

    /*用户——登录*/
    @RequestMapping(path = "/usr/login")
    public Res login(String id, String password, HttpServletRequest request) {
        ResUsr resUsr = usrService.login(id, password);
        if (resUsr.getCode() == 200) {
            request.getSession().setAttribute("uid", resUsr.getUid());
        }
        return new Res(resUsr.getMessage(), resUsr.getCode());
    }

    /*用户——注册*/
    @RequestMapping(path = "/usr/register")
    public Res register(String id, String password){
        return usrService.register(id,password);
    }

    /*用户——登出*/
    @RequestMapping(path = "/usr/logout")
    public Res logout(HttpServletRequest request){
        request.getSession().removeAttribute("uid");
        if(request.getSession().getAttribute("uid") == null)
            return new Res("登出成功",200);
        else
            return new Res("登出失败",500);
    }

    /*用户——注销*/
    @RequestMapping(path = "/usr/delete")
    public Res delete(String uid){ return usrService.delete(uid); }

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
    public Res admin_updateNoP(String id, String name, int sex, int age, String address, int cintegral,float money){
        return usrService.updateNoP(id, name, sex, age, address, cintegral,money);
    }

    /*用户——点击按钮获取用户碳积分信息*/
    @RequestMapping(path = "/usr/selectUsrUcintegral")
    public int selectUsrUcintegral(String uid){
        return usrService.selectUsrUcintegral(uid);
    }

    @RequestMapping(path = "/usr/goods/readybuy")
    public ResUGC selectUGC(String uid, int gid) {
        return usrService.selectUGC(uid, gid);
    }

    @RequestMapping(path = "/usr/goods/buy")
    public Res buygoods(String uid, int gid, int cid, int number) {
        return usrService.buygoods(uid, gid, cid, number);
    }

    @RequestMapping(path = "/usr/goods/selectmygoods")
    public Page<Usr_Goods> selectmygoods(String uid, int currentPage) {
        return usrService.selectmypagegoods(uid, currentPage);
    }

    @RequestMapping(path = "/usr/goods/rejected")
    public Res rejectgoods(String uid, int gid, int number, String gtime, float gcost){
        return usrService.rejectgoods(uid,gid,number,gtime,gcost);
    }

    @RequestMapping(path ="/usr/selectNoPid")
    public UsrNoP usr_selectNoP(String id){
        return usrService.selectNoPid(id);
    }
}
