package com.edu.zjut.controller;

import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.UsrNoP;
import com.edu.zjut.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsrController {
    UsrService usrService;

    @Autowired
    public void setUsrService(UsrService usrService) { this.usrService = usrService; }

    /*添加*/
//    @RequestMapping(path = "/usr/insert")
//    public Res insert(String id,String name, String password, int sex, int age, String address, int cintegral) {
//        return usrService.insert(id, name, password, sex, age, address, cintegral);
//    }
    /*查询,输出无密码用户信息*/
    @RequestMapping(path = "/usr/selectNoPpage")
    public Page<UsrNoP> selectNoP(int currentPage){ return usrService.selectNoP(currentPage); }

    /*按id查询,输出无密码用户信息*/
    @RequestMapping(path = "/usr/selectNoPid")
    public UsrNoP selectNoPid(String id){return usrService.selectNoPid(id);}

    /*删除*/
    @RequestMapping(path = "/usr/delete")
    public Res delete(String id){ return usrService.delete(id); }

    /*更新*/
    @RequestMapping(path = "/usr/updateNoP")
    public Res updateNoP(String id, String name, int sex, int age, String address, int cintegral){
        return usrService.updateNoP(id, name, sex, age, address, cintegral);
    }
}
