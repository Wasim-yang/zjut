package com.edu.zjut.service;

import com.edu.zjut.entity.Manager;
import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.ResManager;
import com.edu.zjut.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    ManagerMapper managerMapper;

    @Autowired
    public void setManagerMapper(ManagerMapper managerMapper){this.managerMapper=managerMapper;}

    /*管理员登录账号*/
    public ResManager login(String id,String password){
        Manager manager=managerMapper.selectlogin(id,password);
        if(manager==null){
            return new ResManager("登录失败",500,null);
        }
        else
            return new ResManager("登录成功",200,manager.getMid());
    }

    /*管理员注册账号*/
    public Res register(String id,String password){
        int result=managerMapper.register(id,password);
        if(result==1){
            return new Res("注册成功",200);
        }
        else
            return new Res("注册失败",500);
    }

    /*管理员修改账号信息*/
    public Res update(String id,String name,String password) {
        int result = managerMapper.update(id, name, password);
        if (result == 1) {
            return new Res("修改成功", 200);
        } else
            return new Res("修改失败", 500);
    }

}
