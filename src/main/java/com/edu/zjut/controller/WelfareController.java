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
    @RequestMapping(path = "/welfare/insert")
    public Res insert(String wname, String wdescription, int wtotal) {
        return welfareService.insert(wname, wdescription, wtotal);
    }

    /*查询*/
    @RequestMapping(path = "/welfare/selectpage")
    public Page<Welfare> select(int currentPage){ return welfareService.selectpage(currentPage); }

    /*按id查询*/
    @RequestMapping(path="/welfare/selectid")
    public Welfare selectid(int wid){return welfareService.selectid(wid);}

    /*删除*/
    @RequestMapping(path = "/welfare/delete")
    public Res delete(int wid){ return welfareService.delete(wid); }

    /*更新*/
    @RequestMapping(path = "/welfare/update")
    public Res update(int wid, String wname, String wdescription, int wtotal, int wgain){
        return welfareService.update(wid, wname, wdescription, wtotal, wgain);
    }
}
