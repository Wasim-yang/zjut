package com.edu.zjut.mapper;

import com.edu.zjut.entity.Manager;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManagerMapper {

    @Insert("insert into Manager(mid,mpassword) VALUES (#{mid},#{mpassword})")
    int register(@Param("mid") String mid,@Param("mpassword") String mpassword);

    @Insert("insert into Manager VALUES (#{mid},#{mname},#{mpassword})")
    int insert(@Param("mid") String mid,@Param("mname") String mname,@Param("mpassword") String mpassword);

    @Select("select * from Manager where mid=#{mid} and mpassword=#{mpassword}")
    Manager selectlogin(@Param("mid") String mid,@Param("mpassword") String mpassword );

    @Update("update Manager set mpassword=#{mpassword},mname=#{mname} where mid=#{mid}")
    int update(@Param("mid") String mid,@Param("mname") String mname,@Param("mpassword") String mpassword);
}
