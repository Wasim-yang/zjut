package com.edu.zjut.mapper;

import com.edu.zjut.entity.Userlogin;
import org.apache.ibatis.annotations.Mapper;
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

}
