package com.edu.zjut.mapper;
import com.edu.zjut.entity.Coupon;
import com.edu.zjut.entity.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
@Mapper
@Repository
public interface CouponMapper {
    @Insert("insert into Coupon(cname,cdiscount,cdescription,cexpoints) VALUES (#{name},#{discount},#{description},#{expoints})")
    int insert(@Param("name") String name,@Param("discount") float discount ,@Param("expoints") int expoints , @Param("description") String description);

    @Select("with t as (select row_number() over(order by cid) r, * from Coupon) "+
            "select cid, cname, cdiscount, cexpoints,cdescription from t "+ "where r between #{head} and #{tail}")
    ArrayList<Coupon> selectpage(@Param("head") int head, @Param("tail") int tail);  //第head条到第tail条

    @Select("select cid, cname, cdiscount, cexpoints, cdescription from Coupon")
    ArrayList<Coupon> selectall();

    @Select("select cid, cname, cdiscount, cdescription, cexpoints from Coupon where cid=${id}")
    Coupon selectid(int id);

    @Delete("delete from Coupon where cid=#{id}")
    int delete(int id);

    @Update("update Coupon set cname=#{name}, cdiscount=#{discount}, cexpoints=#{expoints}, cdescription=#{description} where cid=#{id}")
    int update(@Param("id") int id,@Param("name") String name,@Param("discount") float discount ,@Param("expoints") int expoints ,
               @Param("description") String description);

}
