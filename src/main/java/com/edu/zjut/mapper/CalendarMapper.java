package com.edu.zjut.mapper;

import com.edu.zjut.entity.Calendar;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/5 19:16
 * @description ：
 */
@Mapper
@Repository
public interface CalendarMapper {

    @Select("select * from Calendar where uid=#{uid} and cayear=#{cayear} and camonth = #{camonth} ")
    ArrayList<Calendar> selectAll(@Param("uid") String uid, @Param("cayear") int cayear, @Param("camonth") int camonth);

    @Update("update Usr set ucintegral = ucintegral + 10 where uid = #{uid} ")
    int addAward(String uid);

    @Insert("insert into Calendar(uid,cayear,camonth,caday) values(#{uid},#{cayear},#{camonth} ,#{caday} ) ")
    int insertCal(@Param("uid") String uid, @Param("cayear") int cayear, @Param("camonth") int camonth, @Param("caday") int caday);

    @Select("select * from Calendar where uid=#{uid}")
    ArrayList<Calendar> selectMyform(String uid);
}
