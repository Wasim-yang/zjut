package com.edu.zjut.mapper;

import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Mapper
@Repository
public interface GoodsMapper {
    @Insert("insert into Goods(gname,gcost,gnumber,gean,gdescription,gimage) VALUES (#{name},#{cost},#{number},#{ean},#{description},#{Filepath})")
    int insert(@Param("name") String name,@Param("cost") float cost ,@Param("number")int number ,@Param("ean") int ean ,
               @Param("description") String description ,@Param("Filepath") String Filepath);

    @Select("with t as (select row_number() over(order by gid) r, * from Goods) "+
            "select gid id,gname name,gcost cost,gnumber number,gean ean,gdescription description,gimage path from t "+
            "where r between #{head} and #{tail}")
    ArrayList<Goods> selectpage(@Param("head") int head,@Param("tail") int tail);  //第head条到第tail条

    @Select("select gid id,gname name,gcost cost,gnumber number,gean ean,gdescription description,gimage path from Goods")
    ArrayList<Goods> selectall();

    @Select("select gid id,gname name,gcost cost,gnumber number,gean ean,gdescription description,gimage path from Goods where gid=#{id}")
    Goods selectid(int id);

    @Delete("delete from Goods where gid=#{id}")
    int delete(int id);

    @Update("update Goods set gname=#{name}, gcost=#{cost}, gnumber=#{number},gean=#{ean},gdescription=#{description},gimage=#{path} where gid=#{id}")
    int update(@Param("id") int id,@Param("name") String name,@Param("cost") float cost ,@Param("number") int number ,
               @Param("ean") int ean ,@Param("description") String description,@Param("path") String path);
}
