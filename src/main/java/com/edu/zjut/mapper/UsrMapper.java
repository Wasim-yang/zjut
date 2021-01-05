package com.edu.zjut.mapper;

import com.edu.zjut.entity.Userlogin;
import com.edu.zjut.entity.UsrNoP;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface UsrMapper {

    @Insert("insert into Usr(uid,upassword) VALUES (#{uid},#{upassword})")
    int register(@Param("uid") String uid, @Param("upassword") String upassword);

//    @Select("select * from Usr")
//    ArrayList<Usr> select();

    @Select("select uid ,upassword, uname, usex ,uage ,uaddress ,ucintegral from Usr where uid=#{uid} and upassword=#{upassword}")
    Userlogin selectlogin(@Param("uid") String uid,@Param("upassword") String upassword);

    @Select("with t as (select row_number() over(order by uid) r, * from Usr) "+
            "select uid, uname, usex, uage, uaddress, ucintegral from t "+
            "where r between #{head} and #{tail}")
    ArrayList<UsrNoP> selectNoPpage(@Param("head") int head, @Param("tail") int tail);

    @Select("select uid ,uname  ,usex ,uage ,uaddress ,ucintegral from Usr")
    ArrayList<UsrNoP> selectNoPall();

    @Select("select uid ,uname  ,usex ,uage ,uaddress ,ucintegral from Usr where uid=#{uid}")
    UsrNoP selectNoPid(String uid);

    @Delete("delete from Usr where uid=#{uid}")
    int delete(String uid);

    @Update("update usr set uname=#{uname}, usex=#{usex}, uage=#{uage}," +
            " uaddress=#{uaddress},ucintegral=#{ucintegral} where uid=#{uid}")
    int updateNoP(@Param("uid") String uid, @Param("uname") String uname, @Param("usex") int usex, @Param("uage") int uage,
               @Param("uaddress") String uaddress, @Param("ucintegral") int ucintegral);
}
