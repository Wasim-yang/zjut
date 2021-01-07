package com.edu.zjut.mapper;

import com.edu.zjut.entity.Task;
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
    @Insert("insert into Task(tname,tdescription,trequirement,taward,ttype,tstartime,tdeadline) VALUES (#{tname},#{tdescription},#{trequirement},#{taward},#{ttype},#{tstartime},#{tdeadline})")
    int insert(@Param("tname") String tname, @Param("tdescription") String tdescription,
               @Param("trequirement") float trequirement, @Param("taward") int taward,
               @Param("ttype") int ttype, @Param("tdeadline") Date tdeadline,
               @Param("tstartime") Date tstartime);

    /*管理员查询所有*/
    @Select("select * from Task")
    ArrayList<Task> selectAll();

    /*用户查询所有*/
    @Select("select * from Usr_Task_View where not exists (select * from Usr_Task where Usr_Task_View.tid = Usr_Task.tid and Usr_Task.tstate=1 ) ")
    ArrayList<Task> selectAllUser();

    /*按页查询*/
    @Select("with t as (select row_number() over(order by tid) r, * from Task) " +
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Task> selectByPage(@Param("head") int head, @Param("tail") int tail);

    /*按页查询*/
    @Select("with t as (select row_number() over(order by tid) r, * from Usr_Task_View) " +
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Task> selectByPageUser(@Param("head") int head, @Param("tail") int tail);

    /*查询一个*/
    @Select("select * from Task where tid=#{tid}")
    Task selectOne(int tid);

    /*删除*/
    @Delete("delete from Task where tid = #{tid} ")
    int delete(int tid);

    /*更新*/
    @Update("update Task set tname=#{tname},tdescription=#{tdescription},trequirement=#{trequirement},taward=#{taward},ttype=#{ttype},tdeadline=#{tdeadline} where tid=#{tid}")
    int update(@Param("tname") String tname, @Param("tdescription") String tdescription, @Param("trequirement") float trequirement, @Param("taward") int taward, @Param("ttype") int ttype,
               @Param("tdeadline") Date tdeadline, @Param("tid") int tid);

    @Update("update Usr set ucintegral=ucintegral+#{taward} where uid=#{uid}")
    int update_user(@Param("uid") String uid,
                    @Param("taward") int taward);

    @Update("update Usr_Task set tstate = 1 where uid=#{uid} and tid=#{tid}")
    int update_Usr_Task(@Param("uid") String uid,@Param("tid") int tid);





}


