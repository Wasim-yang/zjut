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
        } else {
            return new Res("充值失败，请重试", 500);
        }
    }

    public Userlogin selectAll(String uid) {
        return usrManageMapper.selectAll(uid);
    }

    public int getCouponNum(String uid) {
        return usrManageMapper.getCouponNum(uid);
    }

    public Res updateName(String uid, String uname) {
        int result = usrManageMapper.updateName(uid, uname);
        if (result == 1) {
            return new Res("修改成功！", 200);
        } else {
            return new Res("修改失败，请重试", 500);
        }
    }

    public Res updateSex(String uid, String usex) {
        int result = usrManageMapper.updateSex(uid, usex);
        if (result == 1) {
            return new Res("修改成功！", 200);
        } else {
            return new Res("修改失败，请重试", 500);
        }
    }

    public Res updateAge(String uid, String uage) {
        int result = usrManageMapper.updateAge(uid, uage);
        if (result == 1) {
            return new Res("修改成功！", 200);
        } else {
            return new Res("修改失败，请重试", 500);
        }
    }

    public Res updateAddress(String uid, String uaddr) {
        int result = usrManageMapper.updateAddress(uid, uaddr);
        if (result == 1) {
            return new Res("修改成功！", 200);
        } else {
            return new Res("修改失败，请重试", 500);
        }
    }

    public Res updatePassword(String uid, String upassword) {
        int result = usrManageMapper.updatePassword(uid, upassword);
        if (result == 1) {
            return new Res("修改成功！", 200);
        } else {
            return new Res("修改失败，请重试", 500);
        }
    }

    public Res deleteUsr(String uid){
        int result = usrManageMapper.deleteUsr(uid);
        if (result == 1) {
            return new Res("注销成功！", 200);
        } else {
            return new Res("注销失败，请重试", 500);
        }
    }
}
