package com.edu.zjut.service;

import com.edu.zjut.entity.Coupon;
import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Res;
import com.edu.zjut.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CouponService {
    CouponMapper couponMapper;
    @Autowired
    public void setCouponMapper(CouponMapper couponMapper) {this.couponMapper = couponMapper;
    }
    /*添加*/
    public Res insert(String name, float discount, int expoints, String description) {
        int result = couponMapper.insert(name, discount, expoints, description);
        if (result == 1) {
            return new Res("添加成功！",200);
        } else
            return new Res("添加失败！",500 );
    }
    /*按id查找*/
    public Coupon selectid(int id){return (couponMapper.selectid(id));}
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
    public Res update(int id, String name, float discount, int expoints, String description) {
        int result = couponMapper.update(id, name, discount, expoints, description);
        if (result == 1) {
            return new Res("更新成功！", 200);
        } else
            return new Res("更新失败！", 500);
    }
}
