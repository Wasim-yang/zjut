package com.edu.zjut.service;

import com.edu.zjut.entity.Pleader;
import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.ResPleader;
import com.edu.zjut.mapper.PleaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PleaderService {
    PleaderMapper pleaderMapper;

    @Autowired
    public void setPleaderMapper(PleaderMapper pleaderMapper) {
        this.pleaderMapper = pleaderMapper;
    }

    /*项目负责人登录账号*/
    public ResPleader login(String id, String password){
        Pleader pleader=pleaderMapper.selectlogin(id,password);
        if(pleader==null){
            return new ResPleader("登录失败",500,null);
        }
        else
            return new ResPleader("登录成功",200,pleader.getPid());
    }

    /*项目负责人注册账号*/
    public Res register(String id, String password){
        int result=pleaderMapper.register(id,password);
        if(result==1){
            return new Res("注册成功",200);
        }
        else
            return new Res("注册失败",500);
    }

    /*项目负责人修改账号信息*/
    public Res update(String id,String name,String password) {
        int result = pleaderMapper.update(id, name, password);
        if (result == 1) {
            return new Res("修改成功", 200);
        } else
            return new Res("修改失败", 500);
    }
}
