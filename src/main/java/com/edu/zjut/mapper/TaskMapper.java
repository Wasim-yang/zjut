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
    @Insert("insert into Task(tname,tdescription,trequirement,taward,ttype,tstartime,tdeadline) VALUES (#{tname},#{tdescription},#{trequirement},#{taward},#{ttype},#{tstartime},#{tdeadline})")
    int insert(@Param("tname") String tname, @Param("tdescription") String tdescription,
               @Param("trequirement") float trequirement, @Param("taward") int taward,
               @Param("ttype") int ttype, @Param("tstartime") Date tstartime,
               @Param("tdeadline") Date tdeadline);

    /*管理员查询所有*/
    @Select("select * from Task")
    ArrayList<Task> selectAll();

    /*用户查询所有*/
    @Select("select Task.*,sum(tmileage) tgain from Task  left join Travellog " +
            "on Task.ttype=Travellog.ttype and Travellog.utime>Task.tstartime and Travellog.utime < Task.tdeadline and uid =#{uid} " +
            "where not exists (select * from Usr_Task where Task.tid = Usr_Task.tid and Usr_Task.tstate=1 and Usr_Task.uid =#{uid} " +
            "or (#{time} <= Task.tstartime or #{time} >= Task.tdeadline)) " +
            "Group by Task.tid,Task.tname,Task.tname,Task.tdescription," +
            "Task.trequirement,Task.taward,Task.tdeadline,Task.tstartime,Task.ttype,Travellog.uid")
    ArrayList<Task> selectAllUser(@Param("uid") String uid,@Param("time") Date time);

    /*按页查询*/
    @Select("with t as (select row_number() over(order by tid) r, * from Task) " +
            "select * from t where r between #{head} and #{tail}")
    ArrayList<Task> selectByPage(@Param("head") int head, @Param("tail") int tail);

    /*用户按页查询*/
    @Select("with t as (select row_number() over(order by tid) r," +
            " Task.*,sum(tmileage) tgain from Task  left join Travellog " +
            " on Task.ttype=Travellog.ttype and Travellog.utime>Task.tstartime and Travellog.utime < Task.tdeadline and uid =#{uid} " +
            " where not exists (select * from Usr_Task where Task.tid = Usr_Task.tid and Usr_Task.tstate=1 and Usr_Task.uid =#{uid} " +
            " or (#{time} <= Task.tstartime or #{time} >= Task.tdeadline)) " +
            " Group by Task.tid,Task.tname,Task.tname,Task.tdescription, " +
            " Task.trequirement,Task.taward,Task.tdeadline,Task.tstartime,Task.ttype,Travellog.uid) " +
            " select * from t where r between #{head} and #{tail}")
    ArrayList<Task> selectByPageUser(@Param("head") int head, @Param("tail") int tail,
                                     @Param("uid") String uid,@Param("time") Date time);




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

    //更新Usr积分
    @Update("update Usr set ucintegral=ucintegral+#{taward} where uid=#{uid}")
    int update_user(@Param("uid") String uid,
                    @Param("taward") int taward);

    //查询Usr_Task
    @Select("select count(*) from Usr_Task where uid=#{uid} and tid=#{tid} and tstate =0")
    int select_Usr_Task(@Param("uid") String uid, @Param("tid") int tid);

    //将任务插入Usr_Task表并置tstate为1
    @Insert("insert into Usr_Task (uid,tid,tstate) VALUES(#{uid},#{tid},1)")
    int insert_Usr_Task(@Param("uid") String uid, @Param("tid") int tid);

    //更新任务状态
    @Update("update Usr_Task set tstate = 1 where uid=#{uid} and tid=#{tid}")
    int update_Usr_Task(@Param("uid") String uid, @Param("tid") int tid);

    //查询所有完成任务
    @Select("select * from Usr_Task where uid=#{uid} and tstate=1")
    ArrayList<Task> selectAllfinishtask(String uid);

    @Select("with t as (select row_number() over(order by tid) r, * from Task" +
            " where tid in (select tid from Usr_Task where uid = #{uid} and tstate=1 ))" +
            " select * from t where r between #{head} and #{tail}")
    ArrayList<Task> selectPagefinishtask(@Param("uid") String uid, @Param("head") int head, @Param("tail") int tail);

}


