package com.edu.zjut.mapper;
import com.edu.zjut.entity.Coupon;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
@Mapper
@Repository
public interface CouponMapper {
    @Insert("insert into Coupon(cname,cdiscount,cdescription,cexpoints) VALUES (#{name},#{discount},#{description},#{expoints})")
    int insert(@Param("name") String name,@Param("discount") float discount ,@Param("expoints") int expoints , @Param("description") String description);

    @Select("select cid id,cname name,cdiscount discount,cdescription description,cexpoints expoints from Coupon")
            ArrayList<Coupon> select();

    @Select("select cid id,cname name,cdiscount discount,cdescription description,cexpoints expoints from Coupon where cid=${id}")
    Coupon selectid(int id);

    @Delete("delete from Coupon where cid=#{id}")
    int delete(int id);

    @Update("update Coupon set cname=#{name}, cdiscount=#{discount}, cexpoints=#{expoints}, cdescription=#{description} where cid=#{id}")
    int update(@Param("id") int id,@Param("name") String name,@Param("discount") float discount ,@Param("expoints") int expoints ,
               @Param("description") String description);

}
