package com.edu.zjut.mapper;

import com.edu.zjut.entity.Calendar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
}
