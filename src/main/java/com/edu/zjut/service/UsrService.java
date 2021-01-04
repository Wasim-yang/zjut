package com.edu.zjut.service;

import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.UsrNoP;
import com.edu.zjut.mapper.UsrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsrService {
    UsrMapper usrMapper;

    @Autowired
    public void setUsrMapper(UsrMapper usrMapper) { this.usrMapper = usrMapper; }

    /*添加*/
//    public Res insert(String id,String name, String password, int sex, int age, String address, int cintegral) {
//        int result = usrMapper.insert(id, name, password, sex, age, address,cintegral);
//        if (result == 1) {
//            return new Res("insert success", 200);
//        } else
//            return new Res("insert failed", 500);
//    }
    /*按id查找,输出无密码用户信息*/
    public UsrNoP selectNoPid(String id){return (usrMapper.selectNoPid(id));}

    /*查找,输出无密码用户信息*/
    public ArrayList<UsrNoP> selectNoP() { return (usrMapper.selectNoP()); }

    /*删除*/
    public Res delete(String id) {
        int result = usrMapper.delete(id);
        if (result == 1) {
            return new Res("delete success", 200);
        } else
            return new Res("delete failed", 500);
    }

    /*更新,无密码用户信息*/
    public Res updateNoP(String id, String name, int sex, int age, String address, int cintegral) {
        int result = usrMapper.updateNoP(id, name, sex, age, address, cintegral);
        if (result == 1) {
            return new Res("update success", 200);
        } else
            return new Res("update failed", 500);
    }
}
