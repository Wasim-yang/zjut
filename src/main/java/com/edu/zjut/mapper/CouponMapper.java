package com.edu.zjut.mapper;
import com.edu.zjut.entity.Coupon;
import com.edu.zjut.entity.UsrNoP;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
@Mapper
@Repository
public interface CouponMapper {
    @Insert("insert into Coupon(cname,cdiscount,cdescription,cexpoints) VALUES (#{name},#{discount},#{description},#{expoints})")
    int insert(@Param("name") String name,@Param("discount") float discount ,@Param("expoints") int expoints , @Param("description") String description);

    /**
     * 用户插入用户优惠券表
     */
    @Insert("insert into Usr_Coupon(uid,cid,cname,cdiscount,cdescription,ctime) VALUES (#{uid},#{cid},#{cname},#{cdiscount},#{cdescription},#{ctime})")
    int usr_insert(@Param("uid") String uid,@Param("cid") int cid ,@Param("cname") String cname,@Param("cdiscount") float cdiscount,@Param("cdescription") String cdescription,@Param("ctime") String ctime);

    @Select("with t as (select row_number() over(order by cid) r, * from Coupon) "+
            "select cid, cname, cdiscount, cexpoints,cdescription from t "+ "where r between #{head} and #{tail}")
    ArrayList<Coupon> selectpage(@Param("head") int head, @Param("tail") int tail);  //第head条到第tail条

    @Select("with t as (select row_number() over(order by cid) r, * from Coupon) "+
            "select cid, cname, cdiscount, cexpoints,cdescription from t "+ "where r between #{head} and #{tail}")
    ArrayList<Coupon> usr_selectpage(@Param("head") int head, @Param("tail") int tail);  //第head条到第tail条

    @Select("select cid, cname, cdiscount, cexpoints, cdescription from Coupon")
    ArrayList<Coupon> selectall();

    @Select("select cid,cname,cdiscount,cexpoints,cdescription from Coupon where not exists (select cid from Usr_Coupon where Coupon.cid=Usr_Coupon.cid and uid=1)")
    ArrayList<Coupon> usr_selectall();

    @Select("with t as (select row_number() over(order by cid) r, * from Usr_Coupon) "+
            "select cname,cdiscount,cdescription,ctime from t "+ "where r between #{head} and #{tail}")
    ArrayList<Coupon> usr_selectmypage(@Param("head") int head, @Param("tail") int tail);  //第head条到第tail条

    @Select("select cname,cdiscount,cexpoints,cdescription from Coupon where cid in(select cid from Usr_Coupon where Coupon.cid=Usr_Coupon.cid and uid=1)")
    ArrayList<Coupon> usr_selectmycoupons();

    @Select("select cid,cname,cdiscount,cdescription,cexpoints from Coupon where cid=$#{id}")
    Coupon selectid(int id);
    /**
     * 用户优惠券用名字搜索
     */
    @Select("select cid,cname,cdiscount,cexpoints,cdescription from Coupon where not exists (select cid from Usr_Coupon where Coupon.cid=Usr_Coupon.cid and uid=1)and cname=$#{name}")
    Coupon selectname(String name);

    @Select("select cname,cdiscount,cexpoints,cdescription,ctime from Usr_Coupon where cname=$#{name}")
    Coupon selectmycname(String name);

    @Delete("delete from Coupon where cid=#{id}")
    int delete(int id);

    @Update("update Coupon set cname=#{name}, cdiscount=#{discount}, cexpoints=#{expoints}, cdescription=#{description} where cid=#{id}")
    int update(@Param("id") int id,@Param("name") String name,@Param("discount") float discount ,@Param("expoints") int expoints ,
               @Param("description") String description);
    /**
     * 用户表减去用于兑换的碳积分
     */
    @Update("update Usr set ucintegral = ucintegral - (select Coupon.cexpoints from Coupon where cid=#{cid}) where uid=#{uid}")
    int usr_updatepoints(@Param("uid") String uid,@Param("cid") int cid,@Param("cexpoints") int cexpoints);

    @Select("select ucintegral from Usr where uid = #{uid}")
    int usr_selectpoints(String uid);

}
