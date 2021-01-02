package com.edu.zjut.mapper;

import com.edu.zjut.entity.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Mapper
@Repository
public interface GoodsMapper {
    @Insert("insert into Goods(gname,gcost,gnumber,gean,gdescription,gimage) VALUES (#{name},#{cost},#{number},#{ean},#{description},#{Filepath})")
    int insert(@Param("name") String name,@Param("cost") float cost ,@Param("number")int number ,@Param("ean") int ean ,
               @Param("description") String description ,@Param("Filepath") String Filepath);

    @Select("select gid id,gname name,gcost cost,gnumber number,gean ean,gdescription description,gimage path from Goods")
    ArrayList<Goods> select();

    @Select("select gid id,gname name,gcost cost,gnumber number,gean ean,gdescription description,gimage path from Goods where gid=${id}")
    Goods selectid(int id);

    @Delete("delete from Goods where gid=#{id}")
    int delete(int id);

    @Update("update Goods set gname=#{name}, gcost=#{cost}, gnumber=#{number}, gdescription=#{description},gimage=#{path} where gid=#{id}")
    int update(@Param("id") int id,@Param("name") String name,@Param("cost") float cost ,@Param("number") int number ,
               @Param("ean") int ean ,@Param("description") String description,@Param("path") String path);
}
