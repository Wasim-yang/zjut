package com.edu.zjut.mapper;
import com.edu.zjut.entity.Coupon;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
@Mapper
@Repository
public interface CouponMapper {
    @Insert("insert into Coupon(cname,cdiscount,cdescription,cexpoint) VALUES (#{name},#{discount},#{description},#{expoint})")
    int insert(@Param("name") String name,@Param("discount") float discount ,@Param("expoint") int expoint , @Param("description") String description);

    @Select("with t as (select row_number() over(order by cid) r, * from Coupon) "+
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Coupon> selectpage(@Param("head") int head, @Param("tail") int tail);  //第head条到第tail条

    @Select("select * from Coupon")
    ArrayList<Coupon> selectall();

    @Select("select * from Usr_coupon where uid=#{uid}")
    ArrayList<Coupon> usr_selectmycoupons(String uid);

    @Select("select cid,cname,cdiscount,cdescription,cexpoint from Coupon where cid=#{id}")
    Coupon selectid(int id);

    @Select("select * from Usr_Coupon where uid=#{uid} and cid=#{cid}")
    Coupon Usr_selectmycoupon(@Param("uid") String uid,@Param("cid") int cid);

    @Delete("delete from Coupon where cid=#{id}")
    int delete(int id);

    @Update("update Coupon set cname=#{name}, cdiscount=#{discount}, cexpoint=#{expoint}, cdescription=#{description} where cid=#{id}")
    int update(@Param("id") int id,@Param("name") String name,@Param("discount") float discount ,@Param("expoint") int expoint ,
               @Param("description") String description);
    /**
     * 用户插入用户优惠券表
     */
    @Insert("insert into Usr_Coupon VALUES (#{uid},#{cid},#{ctime},#{cname},#{cdiscount},#{cdescription})")
    int usr_insert(@Param("uid") String uid,@Param("cid") int cid ,@Param("cname") String cname,@Param("cdiscount") float cdiscount,@Param("cdescription") String cdescription,@Param("ctime") String ctime);

    /**
     * 查询用户所有未兑换过的优惠券
     */
    @Select("with t as (select row_number() over(order by cid) r, * from Coupon where not exists " +
            "(select cid from Usr_Coupon where Coupon.cid=Usr_Coupon.cid and uid=#{uid})) "+
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Coupon> usr_selectpage(@Param("head") int head, @Param("tail") int tail,@Param("uid") String uid);  //第head条到第tail条

    /**
     * 按页查询用户未兑换过的优惠券
     */
    @Select("select * from Coupon where not exists (select cid from Usr_Coupon where Coupon.cid=Usr_Coupon.cid and uid=#{uid})")
    ArrayList<Coupon> usr_selectall(String uid);

    /**
     * 按页查询用户卡包中所有优惠券
     */
    @Select("with t as (select row_number() over(order by cid) r, * from Usr_Coupon where uid=#{uid}) "+
            "select cname,cdiscount,cdescription,ctime from t where r between #{head} and #{tail}")
    ArrayList<Coupon> usr_selectmypage(@Param("head") int head, @Param("tail") int tail, @Param("uid") String uid);  //第head条到第tail条

    /**
     * 查询用户卡包中所有优惠券
     */
    @Select("select cname,cdiscount,cdescription from Usr_Coupon where uid=#{uid}")
    ArrayList<Coupon> usr_selectmycouponsAll(String uid);

    /**
     * 用户未兑换的优惠券用名字搜索
     */
    @Select("select * from Coupon where not exists (select cid from Usr_Coupon where Coupon.cid=Usr_Coupon.cid and uid=#{uid})and cname like #{name}")
    ArrayList<Coupon> usr_selectNameAll(@Param("uid") String uid, @Param("name") String name);

    @Select("with t as (select row_number() over(order by cid) r, * from Coupon where not exists " +
            "(select cid from Usr_Coupon where Coupon.cid=Usr_Coupon.cid and uid=#{uid}) and cname like #{name}) "+
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Coupon> usr_selectNamePage(@Param("head") int head, @Param("tail") int tail,
                                     @Param("uid") String uid, @Param("name") String name);
    /**
     * 用户拥有的优惠券用名字搜索
     */
    @Select("select cname,cdiscount,cdescription from Usr_Coupon where uid=#{uid} and cname like #{name}")
    ArrayList<Coupon> usr_selectmycNameAll(@Param("uid") String uid ,@Param("name") String name);

    @Select("with t as (select row_number() over(order by cid) r, * from Usr_Coupon " +
            "where uid=#{uid} and cname like #{name} ) select cname,cdiscount,cdescription " +
            "from t where r between #{head} and #{tail}")
    ArrayList<Coupon> usr_selectmycNamePage(@Param("head") int head, @Param("tail") int tail,
                                         @Param("uid") String uid, @Param("name") String name);

    /**
     * 用户表减去用于兑换的碳积分
     */
    @Update("update Usr set ucintegral = ucintegral - (select Coupon.cexpoint from Coupon where cid=#{cid}) where uid=#{uid}")
    int usr_updatepoints(@Param("uid") String uid,@Param("cid") int cid,@Param("cexpoint") int cexpoint);

    /**
     * 获取用户碳积分
     */
    @Select("select ucintegral from Usr where uid = #{uid}")
    int usr_selectpoints(String uid);

    @Delete("delete from Usr_Coupon where uid=#{uid} and cid=#{cid}")
    int usr_delete(@Param("uid") String uid,@Param("cid") int cid);
}
