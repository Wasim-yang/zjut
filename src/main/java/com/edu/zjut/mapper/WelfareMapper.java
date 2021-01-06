package com.edu.zjut.mapper;

import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Usr_Welfare;
import com.edu.zjut.entity.Welfare;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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




    @Update("update Welfare set wgain = #{wgain}+#{wdonate} where wid=#{wid}")
    int update_welfare(@Param("wid")int wid, @Param("wgain")int wgain, @Param("wdonate") int wdonate);

    @Update("update Welfare set wgain = #{wtotal} where wid=#{wid}")
    int update_welfare_total(@Param("wid")int wid, @Param("wgain")int wgain,
                       @Param("wtotal") int wtotal);

    @Update("update Usr set ucintegral = #{ucintegral}-#{wdonate} where uid=#{uid}")
    int update_user(@Param("uid")String uid,
                    @Param("ucintegral")int ucintegral,
                    @Param("wdonate")int wdonate);

    @Update("update Usr set ucintegral = #{ucintegral}-(#{wtotal}-#{wgain}) where uid=#{uid}")
    int update_user_total(@Param("uid")String uid,
                    @Param("ucintegral") int ucintegral,
                    @Param("wtotal") int wtotal,
                    @Param("wgain") int wgain);

    //将用户捐赠积分信息存入Usr_Welfare表
    @Select("select * from Usr_Welfare where uid=#{uid} and wid=#{wid}")
    Usr_Welfare select_Usr_Welfare(@Param("uid")String uid,
                                   @Param("wid")int wid);
    @Insert("insert into Usr_Welfare(uid,wid,wcount) VALUES (#{uid},#{wid},#{wcount})")
    int insert_Usr_Welfare(@Param("uid")String uid,
                           @Param("wid")int wid,
                           @Param("wcount")int wcount);

    @Update("update Usr_Welfare set wcount=#{wcount}+#{wdonate} where uid=#{uid} and wid=#{wid}")
    int update_Usr_Welfare(@Param("uid")String uid,
                           @Param("wid")int wid,
                           @Param("wdonate") int wdonate,
                           @Param("wcount")int wcount);
}
