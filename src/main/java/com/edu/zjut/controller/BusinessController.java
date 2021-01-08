package com.edu.zjut.controller;

import com.edu.zjut.entity.*;
import com.edu.zjut.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BusinessController {
    BusinessService businessService;

    @Autowired
    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

    /*商家——登录*/
    @RequestMapping(path = "/business/login")
    public ResBusiness login(String id, String password, HttpServletRequest request){
        ResBusiness resBusiness=businessService.login(id,password);
        if(resBusiness.getCode() == 200){
            request.getSession().setAttribute("bid",resBusiness.getBid());
            return new ResBusiness("登录成功",200,resBusiness.getBid());
        }
        else {
            return new ResBusiness("登录失败",500,null);
        }
    }

    /*商家——登出*/
    @RequestMapping(path = "/business/logout")
    public Res logout(HttpServletRequest request){
        request.getSession().removeAttribute("bid");
        if(request.getSession().getAttribute("bid") == null)
            return new Res("登出成功",200);
        else
            return new Res("登出失败",500);
    }

    /*按页搜索 该商家 所有用户配送单信息*/
    @RequestMapping(path = "/business/selectByPage")
    public Page<Business_deliver> selectByPage(int currentPage,String bid) {
        return businessService.selectByPage(currentPage,bid);
    }

    /*根据gid按页搜索 该商家 所有用户配送单信息*/
    @RequestMapping(path = "/business/selectByGidPage")
    public Page<Business_deliver> selectByGidPage(int currentPage,int gid,String bid,int type) {
            return businessService.selectByGidPage(currentPage,gid,bid,type);
    }

    /*根据商品名按页搜索 该商家 所有用户配送单信息-模糊查询*/
    @RequestMapping(path = "/business/selectByNamePage")
    public Page<Business_deliver> selectByNamePage(int currentPage,String gname,String bid,int type) {
        return businessService.selectByNamePage(currentPage,gname,bid,type);
    }

    /*更新发货状态*/
    @RequestMapping(path = "/business/updateDeliver")
    public Res updateDeliver(String uid, int gid) {
        return businessService.updateDeliver(uid,gid);
    }

    /*查询商家收款*/
    @RequestMapping(path = "/business/selectMoney")
    public float updateDeliver(String bid) {
        return businessService.selectMoney(bid);
    }

}
