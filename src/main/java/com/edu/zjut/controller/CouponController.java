package com.edu.zjut.controller;
import com.edu.zjut.entity.Coupon;
import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Res;
import com.edu.zjut.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {
    CouponService couponService;
    @Autowired
    public void setCouponService(CouponService couponService) {
        this.couponService = couponService;
    }

    /*添加*/
    @RequestMapping(path = "/admin/coupon/insert")
    public Res insert(String name, float discount , int expoints ,  String description) {
        return couponService.insert(name, discount , expoints ,description);
    }

    /*查询*/
    @RequestMapping(path = "/admin/coupon/selectpage")
    public Page<Coupon> select(int currentpage){ return couponService.selectpage(currentpage);}

   /* 用户兑换完后刷新*/
   @RequestMapping(path = "/usr/coupon/selectpage")
   public Page<Coupon> usr_select(int usrcurrentPage,String uid){ return couponService.usr_selectpage(usrcurrentPage,uid);}

    /*按id查询*/
    @RequestMapping(path="/admin/coupon/selectid")
    public Coupon selectid(int id){return couponService.selectid(id);}

    /*按name查询*/
    @RequestMapping(path = "/usr/coupon/selectname")
    public Page<Coupon> selectname(int usrcurrentPage,String uid, String name){return couponService.selectname(usrcurrentPage,uid,name);}

    /*用户拥有优惠券按name查找*/
    @RequestMapping(path = "/usr/coupon/selectmycname")
    public Page<Coupon> selectmycname(int usrmycurrentPage,String uid,String name){
        return  couponService.selectmycname(usrmycurrentPage,uid,name);
    }

    /*删除*/
    @RequestMapping(path = "/admin/coupon/delete")
    public Res delete(int id){ return couponService.delete(id); }

    /*更新*/
    @RequestMapping(path = "/admin/coupon/update")
    public Res update(int id, String name, float discount , int expoints ,String description){
        return couponService.update(id, name, discount, expoints, description);
    }
    /*用户兑换优惠券*/
    @RequestMapping(path = "/usr/coupon/exchange")
    public Res exchange(String uid,int cid,String cname,float cdiscount,String cdescription,int cexpoint,String ctime){
        return couponService.usr_exchange(uid,cid,cname,cdiscount,cdescription,cexpoint,ctime);
    }
    /*用户查询当前碳积分*/
    @RequestMapping(path = "/usr/coupon/selectpoints")
    public int selectpoints(String uid){
        return couponService.selectpoints(uid);
    }
    /*用户查看拥有的优惠券*/

    @RequestMapping(path = "/usr/coupon/selectmycoupons")
    public Page<Coupon> usr_selectmycoupons(int usrmycurrentPage,String uid){
        return couponService.usr_selectmycoupons(usrmycurrentPage,uid);
    }

}
