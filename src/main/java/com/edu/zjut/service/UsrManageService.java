package com.edu.zjut.service;

import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.Userlogin;
import com.edu.zjut.mapper.UsrManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/7 14:47
 * @description ：
 */
@Repository
public class UsrManageService {
    @Autowired
    UsrManageMapper usrManageMapper;
    public Res topupMoney(String uid) {
        int result = usrManageMapper.topupMoney(uid);
        if (result == 1) {
            return new Res("充值成功！", 200);
        } else{
            return new Res("充值失败，请重试", 500);
        }
    }

    public Userlogin selectAll(String uid) {
        return usrManageMapper.selectAll(uid);
    }
}
