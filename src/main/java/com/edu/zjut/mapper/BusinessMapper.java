package com.edu.zjut.mapper;

import com.edu.zjut.entity.Business;
import com.edu.zjut.entity.Business_deliver;
import com.edu.zjut.entity.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface BusinessMapper {
    /**
     * 注册商家账号
     */
    @Insert("insert into Business(bid,bpassword) VALUES (#{bid},#{bpassword})")
    int register(@Param("bid") String bid, @Param("bpassword") String bpassword);

    /**
     * 添加商家账号完整信息
     */
    @Insert("insert into Business VALUES (#{bid},#{bname},#{bpassword},#{baddress})")
    int insert(@Param("bid") String bid,@Param("bname") String bname,@Param("bpassword") String bpassword,
               @Param("baddress") String baddress);

    /**
     * 验证商家账号
     */
    @Select("select * from Business where bid=#{bid} and bpassword=#{bpassword}")
    Business selectlogin(@Param("bid") String bid, @Param("bpassword") String bpassword );

    /**
     * 更新账号信息
     */
    @Update("update Business set bpassword=#{bpassword},bname=#{bname},baddress=#{baddress} where bid=#{bid}")
    int update(@Param("bid") String bid,@Param("bname") String bname,@Param("bpassword") String bpassword,
               @Param("baddress") String baddress);

    /**
     * 搜索 该商家 存款
     */
    @Select("select bmoney from Business where bid=#{bid}")
    float selectMoney(String bid);

    /**
     * 搜索 该商家 所有用户配送单信息
     */
    @Select("select * from Business_deliver where bid=#{bid}")
    ArrayList<Business_deliver> selectDeliverAll(String bid);

    /**
     * 按页搜索 该商家 所有用户配送单信息
     */
    @Select("with t as (select row_number() over(order by gid) r, * from Business_deliver where bid=#{bid}) " +
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Business_deliver> selectByPage(@Param("head") int head, @Param("tail") int tail,
                                             @Param("bid") String bid);

    /**
     * 按gid搜索 该商家 所有用户 未配送单信息
     */
    @Select("select  * from Business_deliver where gid=#{gid} and bid=#{bid} and gstate=0")
    ArrayList<Business_deliver> selectByGidAllState0(@Param("gid")int gid, @Param("bid") String bid);

    /**
     * 根据gid按页搜索 该商家 所有用户 未配送单信息
     */
    @Select("with t as (select row_number() over(order by gid) r, * from Business_deliver where gid=#{gid} and bid=#{bid} " +
            "and gstate=0) select * from t where r between #{head} and #{tail}")
    ArrayList<Business_deliver> selectByGidPageState0(@Param("head") int head, @Param("tail") int tail,
                                                @Param("gid")int gid,@Param("bid") String bid);
    /**
     * 按gid搜索 该商家 所有用户 配送单信息
     */
    @Select("select  * from Business_deliver where gid=#{gid} and bid=#{bid}")
    ArrayList<Business_deliver> selectByGidAll(@Param("gid")int gid, @Param("bid") String bid);

    /**
     * 根据gid按页搜索 该商家 所有用户 配送单信息
     */
    @Select("with t as (select row_number() over(order by gid) r, * from Business_deliver where gid=#{gid} and bid=#{bid}) " +
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Business_deliver> selectByGidPage(@Param("head") int head, @Param("tail") int tail,
                                                @Param("gid")int gid,@Param("bid") String bid);
    /**
     * 根据商品名搜索 该商家 所有用户 未配送单信息-模糊查询
     */
    @Select("select  * from Business_deliver where gname like #{gname} and bid=#{bid} and gstate=0")
    ArrayList<Business_deliver> selectByNameAllState0(@Param("gname")String gname, @Param("bid") String bid);

    /**
     * 根据商品名按页搜索 该商家 所有用户 未配送单信息-模糊查询
     */
    @Select("with t as (select row_number() over(order by gid) r, * from Business_deliver where gname like #{gname} " +
            "and bid=#{bid} and gstate=0) select * from t where r between #{head} and #{tail}")
    ArrayList<Business_deliver> selectByNamePageState0(@Param("head") int head, @Param("tail") int tail,
                                                @Param("gname")String gname, @Param("bid") String bid);
    /**
     * 根据商品名搜索 该商家 所有用户 配送单信息-模糊查询
     */
    @Select("select  * from Business_deliver where gname like #{gname} and bid=#{bid}")
    ArrayList<Business_deliver> selectByNameAll(@Param("gname")String gname, @Param("bid") String bid);

    /**
     * 根据商品名按页搜索 该商家 所有用户 配送单信息-模糊查询
     */
    @Select("with t as (select row_number() over(order by gid) r, * from Business_deliver where gname like #{gname} and bid=#{bid}) " +
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Business_deliver> selectByNamePage(@Param("head") int head, @Param("tail") int tail,
                                                 @Param("gname")String gname, @Param("bid") String bid);
    /**
     * 该商家 更新发货状态
     */
    @Update("update Usr_Goods set gstate=#{gstate} where uid=#{uid} and gid=#{gid}")
    int updateDeliver(@Param("uid") String uid,@Param("gid") int gid,
                      @Param("gstate") int gstate);

    /**
     * 删除 该商家 用户配送单信息
     */
    @Delete("delete from Usr_Goods where  uid=#{uid} and gid=#{gid}")
    int deleteDeliver(@Param("uid") String uid,@Param("gid") int gid);

    /**
     * 搜索商家上架的所有商品
     */
    @Select("select * from Goods where bid=#{bid}")
    ArrayList<Goods> selectGoodsAll(@Param("bid")String bid);

    /**
     * 按页搜索商家上架的所有商品
     */
    @Select("with t as (select row_number() over(order by gid) r, * from Goods where bid=#{bid}) " +
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Goods> selectGoodsPage(@Param("head") int head, @Param("tail") int tail,
                                                @Param("bid")String bid);
    /**
     * 按gid搜索该商家上架商品
     */
    @Select("select  * from Goods where bid=#{bid} and gid=#{gid}")
    Goods selectGoodsByGidAll(@Param("bid")String bid,@Param("gid")int gid);

    /**
     * 根据商品名搜索该商家上架商品
     */
    @Select("select  * from Goods where bid=#{bid} and gname like #{gname}")
    ArrayList<Goods> selectGoodsByNameAll(@Param("bid")String bid,@Param("gname")String gname);

    /**
     * 根据商品名按页搜索该商家上架商品
     */
    @Select("with t as (select row_number() over(order by gid) r, * from Goods where bid=#{bid} and gname like #{gname}) " +
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Goods> selectGoodsByNamePage(@Param("head") int head, @Param("tail") int tail,
                                           @Param("bid")String bid,@Param("gname")String gname);

}
