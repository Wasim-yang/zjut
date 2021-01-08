package com.edu.zjut.service;

import com.edu.zjut.entity.*;
import com.edu.zjut.mapper.CouponMapper;
import com.edu.zjut.mapper.GoodsMapper;
import com.edu.zjut.mapper.UsrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class UsrService {
    UsrMapper usrMapper;
    GoodsMapper goodsMapper;
    CouponMapper couponMapper;

    @Autowired
    public void setUsrMapper(UsrMapper usrMapper) {
        this.usrMapper = usrMapper;
    }

    @Autowired
    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Autowired
    public void setCouponMapper(CouponMapper couponMapper) {
        this.couponMapper = couponMapper;
    }

    /*用户登录*/
    public ResUsr login(String id,String password){
        Userlogin userlogin=usrMapper.selectlogin(id,password);
        if(userlogin==null){
            return new ResUsr("登陆失败",500,null);
        }
        else
            return new ResUsr("登录成功",200,userlogin.getUid());
    }

    /*用户注册*/
    public Res register(String id,String password){
        if(usrMapper.selectNoPid(id) != null)
            return new Res("该账号已被注册",500);
        int result=usrMapper.register(id,password);
        if(result==1){
            return new Res("注册成功",200);
        }
        else
            return new Res("注册失败",500);
    }

    /*添加*/
//    public Res insert(String id,String name, String password, int sex, int age, String address, int cintegral) {
//        int result = usrMapper.insert(id, name, password, sex, age, address,cintegral);
//        if (result == 1) {
//            return new Res("insert success", 200);
//        } else
//            return new Res("insert failed", 500);
//    }
    /*按id查找,输出无密码用户信息*/
    public UsrNoP selectNoPid(String id) {
        return (usrMapper.selectNoPid(id));
    }

    /*按页查找,输出无密码用户信息*/
    public Page<UsrNoP> selectNoP(int currentPage) {
        Page<UsrNoP> usrNoPPage = new Page<UsrNoP>();
        int head = currentPage * usrNoPPage.getPageSize() - usrNoPPage.getPageSize() + 1;
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
                usrNoPPage.setTotalPage((usrNoPArrayList.size() + usrNoPPage.getPageSize() - 1) / usrNoPPage.getPageSize());
            } else {
                usrNoPPage.setTotalPage((usrNoPArrayList.size() + usrNoPPage.getPageSize() - 1) / usrNoPPage.getPageSize());
                usrNoPPage.setTotalRecord(usrNoPArrayList.size());
                currentPage = currentPage - 1;
                usrNoPPage.setCurrentPage(currentPage);
                head = currentPage * usrNoPPage.getPageSize() - usrNoPPage.getPageSize() + 1;
                tail = currentPage * usrNoPPage.getPageSize();
                ArrayList<UsrNoP> tempusrNoPPage = usrMapper.selectNoPpage(head, tail);
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
    public Res updateNoP(String id, String name, int sex, int age, String address, int cintegral, float umoney) {
        int result = usrMapper.updateNoP(id, name, sex, age, address, cintegral, umoney);
        if (result == 1) {
            return new Res("update success", 200);
        } else
            return new Res("update failed", 500);
    }

//    点击按钮获取用户碳积分
    public int selectUsrUcintegral(String id){
        int res = usrMapper.selectUsrUcintegral(id);
        return  res;
    }

    public ResUGC selectUGC(String uid, int gid) {
        UsrNoP usrNoP = usrMapper.selectNoPid(uid);
        Goods goods = goodsMapper.selectid(gid);
        ArrayList<Coupon> couponArrayList = couponMapper.usr_selectmycoupons(uid);
        ResUGC resUGC = new ResUGC(usrNoP, goods, couponArrayList);
        return resUGC;
    }

    @Transactional
    public Res buygoods(String uid, int gid, int cid, int number) {
        Goods goods = goodsMapper.selectid(gid);
        UsrNoP usrNoP = usrMapper.selectNoPid(uid);
        float cost = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = formatter.format(new Date());
        System.out.println(date);
        if (goods.getGnumber() < number) {
            return new Res("库存不足", 500);
        } else {
            if (cid != 0) {
                Coupon coupon = couponMapper.Usr_selectmycoupon(uid, cid);
                cost = goods.getGcost() * number * coupon.getCdiscount();
                if (usrNoP.getUmoney() < cost) {
                    return new Res("余额不足", 400);
                } else {
                    goodsMapper.insertUG(uid, gid, date, number, cost,goods.getGimage(),goods.getGname(),
                            goods.getGdescription(),0);
                    usrNoP.setUmoney(usrNoP.getUmoney() - cost);
                    usrMapper.updateNopmoney(uid, usrNoP.getUmoney());
                    goodsMapper.updatenumber(number, gid);
                    couponMapper.usr_delete(uid, cid);
                    return new Res("购买成功", 200);
                }
            } else {
                cost = goods.getGcost() * number;
                if (usrNoP.getUmoney() < cost) {
                    return new Res("余额不足", 400);
                } else {
                    goodsMapper.insertUG(uid, gid, date, number, cost, goods.getGimage(), goods.getGname(),
                            goods.getGdescription(),0);
                    usrNoP.setUmoney(usrNoP.getUmoney() - cost);
                    usrMapper.updateNopmoney(uid, usrNoP.getUmoney());
                    goodsMapper.updatenumber(number, gid);
                    return new Res("购买成功", 200);
                }
            }
        }
    }

    public Page<Usr_Goods> selectmypagegoods(String uid, int currentPage) {
        Page<Usr_Goods> goodsPage = new Page<>();
        int head = currentPage * goodsPage.getPageSize() - goodsPage.getPageSize() + 1;
        int tail = currentPage * goodsPage.getPageSize();
        ArrayList<Usr_Goods> goodsArrayList = usrMapper.selectmypagegoods(uid, head, tail);
        ArrayList<Usr_Goods> allmygoods = usrMapper.selectallmygoods(uid);
        if (!allmygoods.isEmpty()) {
            if (!goodsArrayList.isEmpty()) {
                goodsPage.setCurrentPage(currentPage);
                goodsPage.setDataList(goodsArrayList);
                goodsPage.setTotalRecord(allmygoods.size());
                goodsPage.setTotalPage((allmygoods.size() + goodsPage.getPageSize() - 1) / goodsPage.getPageSize());
            } else {
                goodsPage.setTotalPage((allmygoods.size() + goodsPage.getPageSize() - 1) / goodsPage.getPageSize());
                goodsPage.setTotalRecord(allmygoods.size());
                currentPage = currentPage - 1;
                goodsPage.setCurrentPage(currentPage);
                head = currentPage * goodsPage.getPageSize() - goodsPage.getPageSize() + 1;
                tail = currentPage * goodsPage.getPageSize();
                ArrayList<Usr_Goods> tempusrgoodPage = usrMapper.selectmypagegoods(uid, head, tail);
                goodsPage.setDataList(tempusrgoodPage);
            }
        } else {
            goodsPage.setTotalPage(0);
            goodsPage.setTotalRecord(0);
        }
        return goodsPage;
    }

    @Transactional
    public Res rejectgoods(String uid,int gid,int number,String gtime,float gcost){
        System.out.println(gtime);
        //查找商家
        String bid=goodsMapper.selectid(gid).getBid();
        //用户退货后删除购买记录
        goodsMapper.delete_Usr_Goods(uid,gid,gtime);
        //用户退货后商品库存+1
        goodsMapper.update_Goods_gnumber(gid,number);
        //用户退货后商家的钱返还
        goodsMapper.update_Business_bmoney(gcost,bid);
        //用户退货后用户的钱返还
        int result = goodsMapper.update_Usr_umoney(uid,gcost);
        if (result == 1) {
            return new Res("退货成功", 200);
        } else
            return new Res("退货失败", 500);
    }
}

