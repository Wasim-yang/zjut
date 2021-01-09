package com.edu.zjut.mapper;

import com.edu.zjut.entity.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;


@Mapper
@Repository
public interface GoodsMapper {

    //添加货物接口
    @Insert("insert into Goods(gname,gcost,gnumber,gean,gdescription,gimage,bid) VALUES (#{gname},#{gcost},#{gnumber},#{gean},#{gdescription},#{gimage},#{bid})")
    int insert(@Param("gname") String gname, @Param("gcost") float gcost, @Param("gnumber") int gnumber, @Param("gean") int gean,
               @Param("gdescription") String gdescription, @Param("gimage") String Filepath,@Param("bid") String bid);

    //添加用户购买记录接口
    @Insert("insert into Usr_Goods(uid,gid,gtime,ugnumber,ugcost,gimage,gname,gdescription,gstate)" +
            " VALUES  (#{uid},#{gid},#{gtime},#{ugnumber},#{ugcost},#{gimage},#{gname},#{gdescription},#{gstate})")
    int insertUG(@Param("uid") String uid, @Param("gid") int gid, @Param("gtime") String gtime,
                 @Param("ugnumber") int ugnumber, @Param("ugcost") float ugcost, @Param("gimage") String gimage,
                 @Param("gname") String gname, @Param("gdescription") String gdescription, @Param("gstate") int gstate);


    //分页查找货物
    @Select("with t as (select row_number() over(order by gid) r, * from Goods) " +
            "select gid, gname, gcost, gnumber, gean, gdescription, gimage from t " +
            "where r between #{head} and #{tail}")
    ArrayList<Goods> selectpage(@Param("head") int head, @Param("tail") int tail);

    //查找所有货物
    @Select("select * from Goods")
    ArrayList<Goods> selectall();

    //根据名字模糊查找货物
    @Select("select * from Goods where gname like #{name}")
    ArrayList<Goods> selectnameall(String name);

    //根据id查找货物
    @Select("select * from Goods where gid=${gid}")
    Goods selectid(int gid);


    //通过名字分页查找
    @Select("with t as (select row_number() over(order by gid) r, * from Goods) " +
            "select gid, gname, gcost, gnumber, gean, gdescription, gimage from t " +
            "where r between #{head} and #{tail} and gname like #{name}")
    ArrayList<Goods> selectnamepage(@Param("head") int head, @Param("tail") int tail, @Param("name") String name);

    //删除货物
    @Delete("delete from Goods where gid=#{gid}")
    int delete(int gid);


    //更改接口
    @Update("update Goods set gname=#{gname}, gcost=#{gcost}, gnumber=#{gnumber},gean=#{gean},gdescription=#{gdescription},gimage=#{giamge} where gid=#{gid}")
    int update(@Param("gid") int gid, @Param("gname") String gname, @Param("gcost") float gcost, @Param("gnumber") int gnumber,
               @Param("gean") int gean, @Param("gdescription") String gdescription, @Param("giamge") String giamge);

    //购买后商品库存减少
    @Update("update Goods set gnumber=gnumber-#{number} where gid=#{gid}")
    int updatenumber(@Param("number") int number, @Param("gid") int gid);

    //用户退货后删除购买记录
    @Delete("delete from Usr_Goods where uid=#{uid} and gid=#{gid} and gtime=#{gtime}")
    int delete_Usr_Goods(@Param("uid") String uid, @Param("gid") int gid, @Param("gtime") String gtime);

    //用户退货后商品库存增加用户购买数量
    @Update("update Goods set gnumber=gnumber+#{number} where gid=#{gid}")
    int update_Goods_gnumber(@Param("gid") int gid, @Param("number") int nummber);

    //用户退货后商家的钱返还
    @Update("update Business set bmoney=bmoney-#{gcost} where bid=#{bid}")
    int update_Business_bmoney(@Param("gcost") float gcost, @Param("bid") String bid);

    //用户退货后用户的钱返还
    @Update("update Usr set umoney=umoney+#{gcost} where uid=#{uid}")
    int update_Usr_umoney(@Param("uid") String uid, @Param("gcost") float gcost);
}
