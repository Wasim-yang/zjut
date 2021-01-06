package com.edu.zjut.service;

import com.edu.zjut.entity.Business;
import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.ResBusiness;
import com.edu.zjut.mapper.BusinessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    BusinessMapper businessMapper;

    @Autowired
    public void setBusinessMapper(BusinessMapper businessMapper) {
        this.businessMapper = businessMapper;
    }

    /*商家登录账号*/
    public ResBusiness login(String id, String password){
        Business business=businessMapper.selectlogin(id,password);
        if(business==null){
            return new ResBusiness("登录失败",500,null);
        }
        else
            return new ResBusiness("登录成功",200,business.getBid());
    }

    /*商家注册账号*/
    public Res register(String id, String password){
        int result=businessMapper.register(id,password);
        if(result==1){
            return new Res("注册成功",200);
        }
        else
            return new Res("注册失败",500);
    }

    /*商家修改账号信息*/
    public Res update(String id,String name,String password,String address) {
        int result = businessMapper.update(id, name, password,address);
        if (result == 1) {
            return new Res("修改成功", 200);
        } else
            return new Res("修改失败", 500);
    }
}
