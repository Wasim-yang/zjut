package com.edu.zjut.mapper;

import com.edu.zjut.entity.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;


@Mapper
@Repository
public interface GoodsMapper {
    @Insert("insert into Goods(gname,gcost,gnumber,gean,gdescription,gimage) VALUES (#{gname},#{gcost},#{gnumber},#{gean},#{gdescription},#{gimage})")
    int insert(@Param("gname") String gname, @Param("gcost") float gcost, @Param("gnumber") int gnumber, @Param("gean") int gean,
               @Param("gdescription") String gdescription, @Param("gimage") String Filepath);

    @Insert("insert into Usr_Goods(uid,gid,gtime,ugnumber,ugcost,gimage,gname,gdescription,gstate)" +
            " VALUES  (#{uid},#{gid},#{gtime},#{ugnumber},#{ugcost},#{gimage},#{gname},#{gdescription},#{gstate})")
    int insertUG(@Param("uid") String uid, @Param("gid") int gid, @Param("gtime") Date gtime,
                 @Param("ugnumber") int ugnumber, @Param("ugcost") float ugcost, @Param("gimage") String gimage,
                 @Param("gname") String gname, @Param("gdescription") String gdescription, @Param("gstate") int gstate);

    @Select("with t as (select row_number() over(order by gid) r, * from Goods) " +
            "select gid, gname, gcost, gnumber, gean, gdescription, gimage from t " +
            "where r between #{head} and #{tail}")
    ArrayList<Goods> selectpage(@Param("head") int head, @Param("tail") int tail);

    @Select("select gid, gname, gcost, gnumber, gean, gdescription, gimage from Goods")
    ArrayList<Goods> selectall();

    @Select("select * from Goods where gname like #{name}")
    ArrayList<Goods> selectnameall(String name);

    @Select("select * from Goods where gid=${gid}")
    Goods selectid(int gid);

    @Select("with t as (select row_number() over(order by gid) r, * from Goods) " +
            "select gid, gname, gcost, gnumber, gean, gdescription, gimage from t " +
            "where r between #{head} and #{tail} and gname like #{name}")
    ArrayList<Goods> selectnamepage(@Param("head") int head, @Param("tail") int tail, @Param("name") String name);

    @Delete("delete from Goods where gid=#{gid}")
    int delete(int gid);

    @Update("update Goods set gname=#{gname}, gcost=#{gcost}, gnumber=#{gnumber},gean=#{gean},gdescription=#{gdescription},gimage=#{giamge} where gid=#{gid}")
    int update(@Param("gid") int gid, @Param("gname") String gname, @Param("gcost") float gcost, @Param("gnumber") int gnumber,
               @Param("gean") int gean, @Param("gdescription") String gdescription, @Param("giamge") String giamge);

    @Update("update Goods set gnumber=gnumber-#{number} where gid=#{gid}")
    int updatenumber(@Param("number") int number, @Param("gid") int gid);
}
