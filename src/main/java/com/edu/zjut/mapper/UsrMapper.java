package com.edu.zjut.mapper;

import com.edu.zjut.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface UsrMapper {
//    @Insert("insert into Usr VALUES (#{usrNoP.uid},#{usrNoP.uname},#{usrNoP.upassword},#{usrNoP.usex}," +
//            "#{usrNoP.uage},#{usrNoP.uaddress},#{usrNoP.ucintegral})")
//    int insert(UsrNoP usrNoP);

//    @Select("select * from Usr")
//    ArrayList<Usr> select();

    @Select("select * from Usr where uid=#{uid} and upassword=#{upassword}")
    Userlogin selectlogin(@Param("uid") String uid,@Param("upassword") String upassword);

    @Select("with t as (select row_number() over(order by uid) r, * from Usr) "+
            "select uid, uname, usex, uage, uaddress, ucintegral from t "+
            "where r between #{head} and #{tail}")
    ArrayList<UsrNoP> selectNoPpage(@Param("head") int head, @Param("tail") int tail);

    @Select("select * from Usr")
    ArrayList<UsrNoP> selectNoPall();

    @Select("select * from Usr where uid=#{uid}")
    UsrNoP selectNoPid(String uid);

    @Select("select * from Usr_Goods where uid=#{uid}")
    ArrayList<Usr_Goods> selectallmygoods(String uid);

    @Select("with t as (select row_number() over(order by uid) r, * from Usr_Goods where uid=#{uid}) " +
            "select * from t  where r between #{head} and #{tail} ")
    ArrayList<Usr_Goods> selectmypagegoods(@Param("uid") String uid, @Param("head") int head, @Param("tail") int tail);

    @Delete("delete from Usr where uid=#{uid}")
    int delete(String uid);

    @Update("update usr set uname=#{uname}, usex=#{usex}, uage=#{uage}," +
            " uaddress=#{uaddress},ucintegral=#{ucintegral},umoney=#{umoney} where uid=#{uid}")
    int updateNoP(@Param("uid") String uid, @Param("uname") String uname, @Param("usex") int usex, @Param("uage") int uage,
               @Param("uaddress") String uaddress, @Param("ucintegral") int ucintegral,@Param("umoney") float umoney);

    @Update("update usr set umoney=#{umoney} where uid=#{uid}")
    int updateNopmoney(@Param("uid") String uid,@Param("umoney") float umoney);

//    @Select("select gnumber,cid,cname,cdiscount,cdescription from Usr_Coupon,Goods where gid=#{gid}")
//    ResUGC selectUGC(@Param("uid") String uid,@Param("gid") int gid);
}
