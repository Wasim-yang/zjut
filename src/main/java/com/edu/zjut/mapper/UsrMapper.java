package com.edu.zjut.mapper;

import com.edu.zjut.entity.Userlogin;
import com.edu.zjut.entity.UsrNoP;
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

    @Select("with t as (select row_number() over(order by uid) r, * from Usr) " +
            "select uid, uname, usex, uage, uaddress, ucintegral from t " +
            "where r between #{head} and #{tail}")
    ArrayList<UsrNoP> selectNoPpage(@Param("head") int head, @Param("tail") int tail);

    @Select("select uid ,uname  ,usex ,uage ,uaddress ,ucintegral from Usr")
    ArrayList<UsrNoP> selectNoPall();

    @Select("select uid ,uname  ,usex ,uage ,uaddress ,ucintegral from Usr where uid=#{uid}")
    UsrNoP selectNoPid(String uid);

    /**
     *  获取用户碳积分
     */
    @Select("select ucintegral from Usr where uid=#{uid}")
    int  selectUsrUcintegral(String uid);

    @Delete("delete from Usr where uid=#{uid}")
    int delete(String uid);

    @Update("update usr set uname=#{uname}, usex=#{usex}, uage=#{uage}," +
            " uaddress=#{uaddress},ucintegral=#{ucintegral} where uid=#{uid}")
    int updateNoP(@Param("uid") String uid, @Param("uname") String uname, @Param("usex") int usex, @Param("uage") int uage,
                  @Param("uaddress") String uaddress, @Param("ucintegral") int ucintegral);

    /**
     * 用户提交里程时，给用户增加碳积分
     */
    @Update("update usr set ucintegral = ucintegral + #{mileage} where uid=#{uid}")
    int updateAddCintegral(@Param("uid") String uid, @Param("mileage") int tmileage);


}