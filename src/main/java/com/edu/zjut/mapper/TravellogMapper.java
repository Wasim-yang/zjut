package com.edu.zjut.mapper;

import com.edu.zjut.entity.Travellog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Mapper
@Repository
public interface TravellogMapper {
    /**
     * 插入记录
     */
    @Insert("insert into Travellog VALUES (#{uid},#{utime},#{ttype},#{tmileage})")
    int insert(@Param("uid") String uid, @Param("utime") Date utime,
                 @Param("ttype") int ttype, @Param("tmileage") float tmileage);

    /**
     * 按用户账号搜索记录
     */
    @Select("select * from Travellog where uid=#{uid}")
    ArrayList<Travellog> selectid(String uid);

    /**
     * 搜索全部记录
     */
    @Select("select * from Travellog")
    ArrayList<Travellog> selectall();

    /**
     * 按页搜索
     */
    @Select("with t as (select row_number() over(order by uid) r, * from Travellog) "+
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Travellog> selectpage(@Param("head") int head, @Param("tail") int tail);

    /**
     * 按用户账号删除记录
     */
    @Delete("delete from Travellog where uid=#{uid}")
    int delete(String uid);

    /**
     * 按用户账号与时间更新记录
     */
    @Update("update Travellog set ttype=#{ttype}, tmileage=#{tmileage}")
    int update(@Param("uid") String uid, @Param("utime") Date utime,
               @Param("ttype") int ttype, @Param("tmileage") float tmileage);
}
