package com.edu.zjut.service;

import com.edu.zjut.entity.*;
import com.edu.zjut.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class CouponService {
    CouponMapper couponMapper;

    @Autowired
    public void setCouponMapper(CouponMapper couponMapper) {
        this.couponMapper = couponMapper;
    }


    /*添加*/
    public Res insert(String name, float discount, int expoint, String description) {
        int result = couponMapper.insert(name, discount, expoint, description);
        if (result == 1) {
            return new Res("添加成功！",200);
        } else
            return new Res("添加失败！",500 );
    }


    /*用户拥有优惠券兑换*/
    @Transactional
    public Res usr_exchange(String uid, int cid, String cname,float cdiscount,String cdescription,int cexpoint, String ctime) {
        int upoints = couponMapper.usr_selectpoints(uid); //获取用户碳积分
        if (upoints < cexpoint) {
            return new Res("您的积分余额不足!", 500);
        }else {
            //将优惠券加入用户优惠券表
            int result1 = couponMapper.usr_insert(uid, cid,cname,cdiscount,cdescription,ctime);
            //减去用户碳积分
            int result2 = couponMapper.usr_updatepoints(uid, cid, cexpoint);
            if (result1 == 1 && result2 == 1) {
                return new Res("兑换成功！", 200);
            } else
                return new Res("兑换失败！", 500);
        }


    }
    /*用户查询自己的优惠券*/
    public Page<Coupon> usr_selectmycoupons(int usrmycurrentPage,String uid){
        Page<Coupon> usrmycouponPage = new Page<Coupon>();
        int head = usrmycurrentPage * usrmycouponPage.getusrmypageSize()-4;
        int tail = usrmycurrentPage * usrmycouponPage.getusrmypageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Coupon> usrmycouponsArrayList=couponMapper.usr_selectmycouponsAll(uid);
//        /*再按页查询，取该页数据*/
        ArrayList<Coupon> usrmycoupons= couponMapper.usr_selectmypage(head,tail,uid);
         if (!usrmycouponsArrayList.isEmpty()) {
            if(!usrmycoupons.isEmpty()){
                usrmycouponPage.setusrmycurrentPage(usrmycurrentPage);
                usrmycouponPage.setDataList(usrmycoupons);
                usrmycouponPage.setusrmytotalRecord(usrmycouponsArrayList.size());
                usrmycouponPage.setusrmytotalPage((usrmycouponsArrayList.size() + 4) / usrmycouponPage.getusrmypageSize());
            }else{
                usrmycouponPage.setusrmytotalPage((usrmycouponsArrayList.size() + 4) / usrmycouponPage.getusrmypageSize());
                usrmycouponPage.setusrmytotalRecord(usrmycouponsArrayList.size());
                usrmycurrentPage=usrmycurrentPage-1;
                usrmycouponPage.setusrmycurrentPage(usrmycurrentPage);
                head = usrmycurrentPage * usrmycouponPage.getusrmypageSize() - 4;
                tail = usrmycurrentPage *usrmycouponPage.getusrmypageSize();
                ArrayList<Coupon> tempcouponPage=couponMapper.usr_selectmypage(head,tail,uid);
                usrmycouponPage.setDataList(tempcouponPage);
            }
        } else {
            usrmycouponPage.setusrmytotalPage(0);
            usrmycouponPage.setusrmytotalRecord(0);
        }
        return usrmycouponPage;
    }
    /*用户显示当前碳积分*/
    public int selectpoints(String uid){return(couponMapper.usr_selectpoints(uid));}
    /*按id查找*/
    public Coupon selectid(int id){return (couponMapper.selectid(id));}

    /*按name查找*/
    public Page<Coupon> selectname(int usrcurrentPage,String uid,String name){
        name = "%"+name+"%";

        Page<Coupon> usrcouponPage = new Page<Coupon>();
        int head = usrcurrentPage*usrcouponPage.getusrPageSize()-4;
        int tail = usrcurrentPage*usrcouponPage.getusrPageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Coupon> usrcouponsArrayList = couponMapper.usr_selectNameAll(uid,name);
        /*再按页查询，取该页数据*/
        ArrayList<Coupon> usr_coupons = couponMapper.usr_selectNamePage(head,tail,uid,name);
        if (!usrcouponsArrayList.isEmpty()) {
            if(!usr_coupons.isEmpty()){
                usrcouponPage.setusrcurrentPage(usrcurrentPage);
                usrcouponPage.setDataList(usr_coupons);
                usrcouponPage.setusrtotalRecord(usrcouponsArrayList.size());
                usrcouponPage.setusrtotalPage((usrcouponsArrayList.size() + 4) / usrcouponPage.getusrPageSize());
            }else{
                usrcouponPage.setusrtotalPage((usrcouponsArrayList.size() + 4) / usrcouponPage.getusrPageSize());
                usrcouponPage.setusrtotalRecord(usrcouponsArrayList.size());
                usrcurrentPage=usrcurrentPage-1;
                usrcouponPage.setusrcurrentPage(usrcurrentPage);
                head = usrcurrentPage * usrcouponPage.getusrPageSize() - 4;
                tail = usrcurrentPage *usrcouponPage.getusrPageSize();
                ArrayList<Coupon> tempcouponPage=couponMapper.usr_selectNamePage(head,tail,uid,name);
                usrcouponPage.setDataList(tempcouponPage);
            }
        } else {
            usrcouponPage.setusrtotalPage(0);
            usrcouponPage.setusrtotalRecord(0);
        }
        return usrcouponPage;
    }
    /*用户拥有优惠券按name查找*/
    public Page<Coupon> selectmycname(int usrmycurrentPage,String uid,String name){
        name = "%"+name+"%";

        Page<Coupon> usrmycouponPage = new Page<Coupon>();
        int head = usrmycurrentPage * usrmycouponPage.getusrPageSize()-4;
        int tail = usrmycurrentPage * usrmycouponPage.getusrPageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Coupon> usrmycouponsArrayList = couponMapper.usr_selectmycNameAll(uid,name);
        /*再按页查询，取该页数据*/
        ArrayList<Coupon> usrmycoupons= couponMapper.usr_selectmycNamePage(head,tail,uid,name);
        if (!usrmycouponsArrayList.isEmpty()) {
            if(!usrmycoupons.isEmpty()){
                usrmycouponPage.setusrmycurrentPage(usrmycurrentPage);
                usrmycouponPage.setDataList(usrmycoupons);
                usrmycouponPage.setusrmytotalRecord(usrmycouponsArrayList.size());
                usrmycouponPage.setusrmytotalPage((usrmycouponsArrayList.size() + 4) / usrmycouponPage.getusrmypageSize());
            }else{
                usrmycouponPage.setusrmytotalPage((usrmycouponsArrayList.size() + 4) / usrmycouponPage.getusrmypageSize());
                usrmycouponPage.setusrmytotalRecord(usrmycouponsArrayList.size());
                usrmycurrentPage=usrmycurrentPage-1;
                usrmycouponPage.setusrmycurrentPage(usrmycurrentPage);
                head = usrmycurrentPage * usrmycouponPage.getusrmypageSize() - 4;
                tail = usrmycurrentPage *usrmycouponPage.getusrmypageSize();
                ArrayList<Coupon> tempcouponPage=couponMapper.usr_selectmycNamePage(head,tail,uid,name);
                usrmycouponPage.setDataList(tempcouponPage);
            }
        } else {
            usrmycouponPage.setusrmytotalPage(0);
            usrmycouponPage.setusrmytotalRecord(0);
        }
        return usrmycouponPage;
    }
    /*按页查找*/
    public Page<Coupon> selectpage(int currentPage) {
        Page<Coupon> couponPage = new Page<Coupon>();
        int head=currentPage*couponPage.getPageSize()-4;
        int tail=currentPage*couponPage.getPageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Coupon> couponsArrayList=couponMapper.selectall();
        /*再按页查询，取该页数据*/
        ArrayList<Coupon> coupons = couponMapper.selectpage(head,tail);
        if (!couponsArrayList.isEmpty()) {
            if(!coupons.isEmpty()){
            couponPage.setCurrentPage(currentPage);
            couponPage.setDataList(coupons);
            couponPage.setTotalRecord(couponsArrayList.size());
            couponPage.setTotalPage((couponsArrayList.size() + 4) / couponPage.getPageSize());
        }else{
            couponPage.setTotalPage((couponsArrayList.size() + 4) / couponPage.getPageSize());
            couponPage.setTotalRecord(couponsArrayList.size());
            currentPage=currentPage-1;
            couponPage.setCurrentPage(currentPage);
            head = currentPage * couponPage.getPageSize() - 4;
            tail = currentPage *couponPage.getPageSize();
            ArrayList<Coupon> tempcouponPage=couponMapper.selectpage(head,tail);
            couponPage.setDataList(tempcouponPage);
       }
       } else {
            couponPage.setTotalPage(0);
            couponPage.setTotalRecord(0);
        }
        return couponPage;
    }

    /*兑换后取该页数据*/
    public Page<Coupon> usr_selectpage(int usrcurrentPage,String uid) {
        Page<Coupon> usrcouponPage = new Page<Coupon>();
        int head = usrcurrentPage*usrcouponPage.getusrPageSize()-4;
        int tail = usrcurrentPage*usrcouponPage.getusrPageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Coupon> usrcouponsArrayList=couponMapper.usr_selectall(uid);
        /*再按页查询，取该页数据*/
        ArrayList<Coupon> usr_coupons = couponMapper.usr_selectpage(head,tail,uid);
        if (!usrcouponsArrayList.isEmpty()) {
            if(!usr_coupons.isEmpty()){
                usrcouponPage.setusrcurrentPage(usrcurrentPage);
                usrcouponPage.setDataList(usr_coupons);
                usrcouponPage.setusrtotalRecord(usrcouponsArrayList.size());
                usrcouponPage.setusrtotalPage((usrcouponsArrayList.size() + 4) / usrcouponPage.getusrPageSize());
            }else{
                usrcouponPage.setusrtotalPage((usrcouponsArrayList.size() + 4) / usrcouponPage.getusrPageSize());
                usrcouponPage.setusrtotalRecord(usrcouponsArrayList.size());
                usrcurrentPage=usrcurrentPage-1;
                usrcouponPage.setusrcurrentPage(usrcurrentPage);
                head = usrcurrentPage * usrcouponPage.getusrPageSize() - 4;
                tail = usrcurrentPage *usrcouponPage.getusrPageSize();
                ArrayList<Coupon> tempcouponPage=couponMapper.usr_selectpage(head,tail,uid);
                usrcouponPage.setDataList(tempcouponPage);
            }
        } else {
            usrcouponPage.setusrtotalPage(0);
            usrcouponPage.setusrtotalRecord(0);
        }
        return usrcouponPage;
    }
    /*删除*/
    public Res delete(int id) {
        /*删除数据库数据*/
        int result = couponMapper.delete(id);
        if (result == 1) {
            return new Res("删除成功！", 200);
        } else
            return new Res("删除失败！", 500);
    }
    /*更新*/
    public Res update(int id, String name, float discount, int expoint, String description) {
        int result = couponMapper.update(id, name, discount, expoint, description);
        if (result == 1) {
            return new Res("更新成功！", 200);
        } else
            return new Res("更新失败！", 500);
    }
}
