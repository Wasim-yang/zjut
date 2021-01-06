package com.edu.zjut.mapper;

import com.edu.zjut.entity.Business;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BusinessMapper {

    @Insert("insert into Business(bid,bpassword) VALUES (#{bid},#{bpassword})")
    int register(@Param("bid") String bid, @Param("bpassword") String bpassword);

    @Insert("insert into Business VALUES (#{bid},#{bname},#{bpassword},#{baddress})")
    int insert(@Param("bid") String bid,@Param("bname") String bname,@Param("bpassword") String bpassword,
               @Param("baddress") String baddress);

    @Select("select * from Business where bid=#{bid} and bpassword=#{bpassword}")
    Business selectlogin(@Param("bid") String bid, @Param("bpassword") String bpassword );

    @Update("update Business set bpassword=#{bpassword},bname=#{bname},baddress=#{baddress} where bid=#{bid}")
    int update(@Param("bid") String bid,@Param("bname") String bname,@Param("bpassword") String bpassword,
               @Param("baddress") String baddress);
}
