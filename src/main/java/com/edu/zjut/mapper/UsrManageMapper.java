package com.edu.zjut.mapper;

import com.edu.zjut.entity.Userlogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/7 14:49
 * @description ：
 */
@Mapper
@Repository
public interface UsrManageMapper {
    /*个人中心*/

    @Update("update Usr set umoney = umoney+10 where uid=#{uid}")
    int topupMoney(String uid);

    @Select("select * from Usr where uid=#{uid} ")
    Userlogin selectAll(String uid);

    @Select("select count(*) from Usr_Coupon where uid=#{uid} ")
    int getCouponNum(String uid);

    @Update("update Usr set uname=#{uname} where uid=#{uid}  ")
    int updateName(@Param("uid") String uid, @Param("uname") String uname);

    @Update("update Usr set usex=#{usex} where uid=#{uid}")
    int updateSex(@Param("uid") String uid, @Param("usex") String usex);

    @Update("update Usr set uaddress=#{uaddress} where uid=#{uid}")
    int updateAddress(@Param("uid") String uid, @Param("uaddress") String uaddress);

    @Update("update Usr set uage=#{uage} where uid=#{uid}")
    int updateAge(@Param("uid") String uid, @Param("uage") String uage);

    @Update("update Usr set uage=#{uage} where uid=#{uid}")
    int updatePassword(String uid, String upasswd);
}
