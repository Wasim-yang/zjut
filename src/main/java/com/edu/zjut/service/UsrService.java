package com.edu.zjut.service;

import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Page;
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

    /*按页查找,输出无密码用户信息*/
    public Page<UsrNoP> selectNoP(int currentPage) {
        Page<UsrNoP> usrNoPPage = new Page<UsrNoP>();
        int head = currentPage * usrNoPPage.getPageSize() - 4;
        int tail = currentPage * usrNoPPage.getPageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<UsrNoP> usrNoPArrayList = usrMapper.selectNoPall();
        /*再按页查询，取该页数据*/
        ArrayList<UsrNoP> usrNoP = usrMapper.selectNoPpage(head, tail);
        if (!usrNoPArrayList.isEmpty()) {
            if (!usrNoP.isEmpty()) {
                usrNoPPage.setCurrentPage(currentPage);
                usrNoPPage.setDataList(usrNoP);
                usrNoPPage.setTotalRecord(usrNoPArrayList.size());
                usrNoPPage.setTotalPage((usrNoPArrayList.size() + 4) / usrNoPPage.getPageSize());
            } else {
                usrNoPPage.setTotalPage((usrNoPArrayList.size() + 4) / usrNoPPage.getPageSize());
                usrNoPPage.setTotalRecord(usrNoPArrayList.size());
                currentPage=currentPage-1;
                usrNoPPage.setCurrentPage(currentPage);
                head = currentPage * usrNoPPage.getPageSize() - 4;
                tail = currentPage * usrNoPPage.getPageSize();
                ArrayList<UsrNoP> tempusrNoPPage=usrMapper.selectNoPpage(head,tail);
                usrNoPPage.setDataList(tempusrNoPPage);
            }
        } else {
            usrNoPPage.setTotalPage(0);
            usrNoPPage.setTotalRecord(0);
        }
        return usrNoPPage;
    }

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

//    点击按钮获取用户碳积分
    public int selectUsrUcintegral(String id){
        int res = usrMapper.selectUsrUcintegral(id);
        System.out.println(res);
        return  res;
    }

}

