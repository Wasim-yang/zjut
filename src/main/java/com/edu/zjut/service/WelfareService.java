package com.edu.zjut.service;

import com.edu.zjut.entity.*;
import com.edu.zjut.mapper.WelfareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class WelfareService {

    WelfareMapper welfareMapper;

    @Autowired
    public void setWelfareMapper(WelfareMapper welfareMapper) {
        this.welfareMapper = welfareMapper;
    }

    /*添加*/
    public Res insert(String wname, String wdescription, int wtotal) {
        int result = welfareMapper.insert(wname, wdescription, wtotal);
        if (result == 1) {
            return new Res("insert success", 200);
        } else
            return new Res("insert failed", 500);
    }

    /*按id查找*/
    public Welfare selectid(int wid) {
        return (welfareMapper.selectid(wid));
    }

    //    /*查找*/
//    public ArrayList<Welfare> select() { return (welfareMapper.select()); }
    /*按页查找*/
    public Page<Welfare> selectpage(int currentPage) {
        Page<Welfare> welfarePage = new Page<Welfare>();
        int head=currentPage*welfarePage.getPageSize()-4;
        int tail=currentPage*welfarePage.getPageSize();
        ArrayList<Welfare> welfareArrayList=welfareMapper.selectall();
        ArrayList<Welfare> welfare = welfareMapper.selectpage(head,tail);
        if (!welfareArrayList.isEmpty()) {
            if (!welfare.isEmpty()) {
                welfarePage.setCurrentPage(currentPage);
                welfarePage.setDataList(welfare);
                welfarePage.setTotalRecord(welfareArrayList.size());
                welfarePage.setTotalPage((welfareArrayList.size() + 4) / welfarePage.getPageSize());
            } else {
                welfarePage.setTotalPage((welfareArrayList.size() + 4) / welfarePage.getPageSize());
                welfarePage.setTotalRecord(welfareArrayList.size());
                currentPage=currentPage-1;
                welfarePage.setCurrentPage(currentPage);
                head = currentPage * welfarePage.getPageSize() - 4;
                tail = currentPage * welfarePage.getPageSize();
                ArrayList<Welfare> tempwelfarePage=welfareMapper.selectpage(head,tail);
                welfarePage.setDataList(tempwelfarePage);
            }
        } else {
            welfarePage.setTotalPage(0);
            welfarePage.setTotalRecord(0);
        }
        return welfarePage;
    }

    /*删除*/
    public Res delete(int wid) {
//        /*删除数据库数据*/
        int result = welfareMapper.delete(wid);
        if (result == 1) {
            return new Res("delete success", 200);
        } else
            return new Res("delete failed", 500);
    }

    /*更新*/
    public Res update(int wid, String wname, String wdescription, int wtotal, int wgain) {
        int result = welfareMapper.update(wid, wname, wdescription, wtotal, wgain);
        if (result == 1) {
            return new Res("update success", 200);
        } else
            return new Res("update failed", 500);
    }

    /* 用户捐赠积分的更新*/
    @Transactional
    public Res update_c(int wid, String uid, int ucintegral, int wgain, int wtotal, int wdonate) {
        //用户积分>捐赠积分且不为0；捐赠积分与累积之和不大于启动条件
        if ((ucintegral - wdonate) >=0 && ucintegral > 0 &&  (wdonate + wgain) <= wtotal ) {
            Usr_Welfare usr_welfare = welfareMapper.select_Usr_Welfare(uid, wid);
            if (usr_welfare == null) {
                //在公益表中加上捐赠积分
                welfareMapper.update_welfareAddWdonate(wid, wdonate);
                //在用户表中减去捐赠积分
                welfareMapper.update_userDeWdonate(uid, wdonate);
                //将信息加入用户——公益表中
                int result = welfareMapper.insert_Usr_Welfare(uid, wid, wdonate);
                if (result == 1) {
                    return new Res("捐赠成功", 200);
                } else
                    return new Res("捐赠失败", 500);
            } else {
                //在公益表中加上捐赠积分
                welfareMapper.update_welfareAddWdonate(wid, wdonate);
                //在用户表中减去捐赠积分
                welfareMapper.update_userDeWdonate(uid, wdonate);
                //将信息加入用户——公益表中
                int result=welfareMapper.update_Usr_Welfare(uid, wid, wdonate);
                if (result == 1) {
                    return new Res("捐赠成功", 200);
                } else
                    return new Res("捐赠失败", 500);
            }
        }
        //捐赠积分与累积之和大于启动条件
        else if ( (ucintegral - wdonate) >=0 && (wdonate + wgain) > wtotal) {
            Usr_Welfare usr_welfare = welfareMapper.select_Usr_Welfare(uid, wid);
            if (usr_welfare == null) {
                int left = wdonate - (wtotal - wgain); //溢出积分
                wdonate = wtotal - wgain;
                //在公益表中加上捐赠积分
                welfareMapper.update_welfareAddWdonate(wid, wdonate);
                //在用户表中减去捐赠积分
                welfareMapper.update_userDeWdonate(uid, wdonate);
                //将信息加入用户——公益表中
                int result = welfareMapper.insert_Usr_Welfare(uid, wid, wdonate);
                if (result == 1) {
                    return new Res("您已成功捐赠，多余的" + left + "积分已经返还您的账户余额", 200);
                } else
                    return new Res("捐赠失败", 500);
            }else{
                int left = wdonate - (wtotal - wgain); //溢出积分
                wdonate = wtotal - wgain;
                //在公益表中加上捐赠积分
                welfareMapper.update_welfareAddWdonate(wid, wdonate);
                //在用户表中减去捐赠积分
                welfareMapper.update_userDeWdonate(uid, wdonate);
                //将信息加入用户——公益表中
                int result=welfareMapper.update_Usr_Welfare(uid, wid, wdonate);
                if (result == 1) {
                    return new Res("您已成功捐赠，多余的" + left + "积分已经返还您的账户余额", 200);
                } else
                    return new Res("捐赠失败", 500);
            }
            }
        //用户积分不足
        else if ((ucintegral - wdonate) < 0) {
            return new Res("积分不足", 500);
        } else
            return new Res("捐赠失败", 200);
    }

}