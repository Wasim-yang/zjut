package com.edu.zjut.mapper;

import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Welfare;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Mapper
@Repository
public interface WelfareMapper {
    @Insert("insert into Welfare(wname,wdescription,wtotal) VALUES (#{wname},#{wdescription},#{wtotal})")
    int insert(@Param("wname") String wname, @Param("wdescription") String wdescription ,
               @Param("wtotal") int wtotal);

    @Select("with t as (select row_number() over(order by wid) r, * from Welfare) "+
        "select *  from t where r between #{head} and #{tail}")
    ArrayList<Welfare> selectpage(@Param("head") int head, @Param("tail") int tail);

    @Select("select * from Welfare")
    ArrayList<Welfare> selectall();

    @Select("select * from Welfare where wid=${wid}")
    Welfare selectid(int wid);

    @Delete("delete from Welfare where wid=#{wid}")
    int delete(int wid);

    @Update("update Welfare set wname=#{wname}, wdescription=#{wdescription},wtotal=#{wtotal}, wgain=#{wgain} where wid=#{wid}")
    int update(@Param("wid")int wid, @Param("wname") String wname, @Param("wdescription") String wdescription,
               @Param("wtotal") int wtotal, @Param("wgain") int wgain);


}
