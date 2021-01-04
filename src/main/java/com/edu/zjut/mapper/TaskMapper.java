package com.edu.zjut.mapper;

import com.edu.zjut.entity.Task;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;


/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/3 16:11
 * @description ：
 */
@Mapper
@Repository
public interface TaskMapper {
    @Insert("insert into Task(tname,tdescription,trequirement,taward,ttype,tdeadline) VALUES (#{tname},#{tdescription},#{trequirement},#{taward},#{ttype},#{tdeadline})")
    int insert(@Param("tname") String tname, @Param("tdescription") String tdescription, @Param("trequirement") float trequirement, @Param("taward") int taward, @Param("ttype") int ttype,
               @Param("tdeadline") Date tdeadline);
    @Select("select * from Task ")
    ArrayList<Task> selectAll();
    @Delete("delete from Task where tid = #{tid} ")
    int delete(int tid);
}
