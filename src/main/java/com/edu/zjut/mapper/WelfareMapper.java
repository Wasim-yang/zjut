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

//    @Select("select wid wid,wname wname,wdescription wdescription,wtotal wtotal,wgain wgain from Welfare")
//    ArrayList<Welfare> select();
    @Select("with t as (select row_number() over(order by wid) r, * from Welfare) "+
        "select wid wid,wname wname,wtotal wtotal,wgain wgain,wdescription wdescription  from t "+
        "where r between #{head} and #{tail}")
    ArrayList<Welfare> selectpage(@Param("head") int head, @Param("tail") int tail);

    @Select("select wid wid,wname wname,wtotal wtotal,wdescription wdescription from Welfare")
    ArrayList<Welfare> selectall();

    @Select("select wid wid,wname wname,wtotal wtotal,wgain wgain ,wdescription wdescription from Welfare where wid=${wid}")
    Welfare selectid(int wid);

    @Delete("delete from Welfare where wid=#{wid}")
    int delete(int wid);

    @Update("update Welfare set wname=#{wname}, wdescription=#{wdescription},wtotal=#{wtotal}, wgain=#{wgain} where wid=#{wid}")
    int update(@Param("wid")int wid, @Param("wname") String wname, @Param("wdescription") String wdescription,
               @Param("wtotal") int wtotal, @Param("wgain") int wgain);

    @Update("begin transaction T1" +
            "update Welfare " +
            "set wgain=case when #{wgain}+#{wdonate}>#{wtotal} then #{wtotal} " +
            "else #{wgain}+#{wdonate} end " +
            "where wid=#{wid} and #{wtotal}>#{wgain}" +
            "update Usr" +
            "set ucintegral=case when (#{ucintegral}-#{wdonate})>0 then #{ucintegral}-#{wdonate}" +
            "else ucintegral end" +
            "commit transaction")
    int update_user(@Param("wid")int wid,@Param("uid")String uid, @Param("wgain")int wgain,
                    @Param("wtotal") int wtotal,@Param("wdonate") int wdonate);

}
