package com.edu.zjut.mapper;

import com.edu.zjut.entity.Pleader;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PleaderMapper {
    @Insert("insert into Pleader(pid,ppassword) VALUES (#{pid},#{ppassword})")
    int register(@Param("pid") String pid, @Param("ppassword") String ppassword);

    @Insert("insert into Pleader VALUES (#{pid},#{pname},#{bppassword})")
    int insert(@Param("pid") String pid,@Param("pname") String pname,@Param("ppassword") String ppassword);

    @Select("select * from Pleader where pid=#{pid} and ppassword=#{ppassword}")
    Pleader selectlogin(@Param("pid") String pid, @Param("ppassword") String ppassword );

    @Update("update Pleader set ppassword=#{ppassword},pname=#{pname} where pid=#{pid}")
    int update(@Param("pid") String pid,@Param("pname") String pname,@Param("ppassword") String ppassword);
}
