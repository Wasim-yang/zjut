package com.edu.zjut.controller;

import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Welfare;
import com.edu.zjut.entity.Res;
import com.edu.zjut.service.WelfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class WelfareController {

    WelfareService welfareService;

    @Autowired
    public void setWelfareService(WelfareService welfareService) {
        this.welfareService = welfareService;
    }

    /*添加*/
    @RequestMapping(path = "/admin/welfare/insert")
    public Res insert(String wname, String wdescription, int wtotal) {
        return welfareService.insert(wname, wdescription, wtotal);
    }

    /*管理员查询公益项目*/
    @RequestMapping(path = "/admin/welfare/selectpage")
    public Page<Welfare> select(int currentPage){ return welfareService.selectpage(currentPage); }

    /*管理员按id查询*/
    @RequestMapping(path="/admin/welfare/selectid")
    public Welfare selectid(int wid){return welfareService.selectid(wid);}

    /*删除*/
    @RequestMapping(path = "/admin/welfare/delete")
    public Res delete(int wid){ return welfareService.delete(wid); }

    /*更新*/
    @RequestMapping(path = "/admin/welfare/update")
    public Res update(int wid, String wname, String wdescription, int wtotal, int wgain){
        return welfareService.update(wid, wname, wdescription, wtotal, wgain);
    }

    /*用户按id查询*/
    @RequestMapping(path="/usr/welfare/selectid")
    public Welfare usr_selectid(int wid){return welfareService.selectid(wid);}

    /*用户查询公益项目*/
    @RequestMapping(path = "/usr/welfare/selectpage")
    public Page<Welfare> usr_select(int currentPage){ return welfareService.selectpage(currentPage); }

    /* 用户捐赠积分的更新*/
    @RequestMapping(path = "/usr/welfare/update_user")
    public Res update_c(int wid,String uid,int ucintegral,int wgain,int wtotal,int wdonate)
    {
        return welfareService.update_c(wid,uid,ucintegral,wgain,wtotal,wdonate);
    }
}
