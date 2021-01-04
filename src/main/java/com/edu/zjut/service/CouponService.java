package com.edu.zjut.service;

import com.edu.zjut.entity.Coupon;
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

    /*查找*/
    public ArrayList<Coupon> select() { return (couponMapper.select()); }

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
