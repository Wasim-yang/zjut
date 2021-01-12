package com.edu.zjut.service;

import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.Task;
import com.edu.zjut.mapper.TaskMapper;
import com.edu.zjut.mapper.UsrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/3 16:11
 * @description ：
 */
@Service
public class TaskService {
    TaskMapper taskMapper;
    UsrMapper usrMapper;

    @Autowired
    public void setTaskMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Autowired
    public void setUsrMapper(UsrMapper usrMapper) {
        this.usrMapper = usrMapper;
    }

    /*添加*/
    public Res insert(String tname, String tdescription, float trequirement, int taward, int ttype, Date tstartime, Date tdeadline) {
        int result = taskMapper.insert(tname, tdescription, trequirement, taward, ttype, tstartime, tdeadline);
        if (result == 1) {
            return new Res("insert success", 200);
        } else {
            return new Res("insert failed", 500);
        }
    }

    /*管理员查找全部*/
    public ArrayList<Task> selectAll() {
        ArrayList<Task> tasks = taskMapper.selectAll();
        return taskMapper.selectAll();

    }

//    /*用户查找全部*/
//    public ArrayList<Task> selectAllUser(String uid) {
//        ArrayList<Task> tasks = taskMapper.selectAllUser(uid);
//        return tasks;
//
//    }

    /*按页查找*/
    public Page<Task> selectByPage(int currentPage) {
        Page<Task> taskPage = new Page<Task>();
        int head = currentPage * taskPage.getPageSize() - 4;
        int tail = currentPage * taskPage.getPageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Task> taskArrayList = taskMapper.selectAll();
        /*再按页查询，取该页数据*/
        ArrayList<Task> task = taskMapper.selectByPage(head, tail);
        if (!taskArrayList.isEmpty()) {
            if (!task.isEmpty()) {
                taskPage.setCurrentPage(currentPage);
                taskPage.setDataList(task);
                taskPage.setTotalRecord(taskArrayList.size());
                taskPage.setTotalPage((taskArrayList.size() + 4) / taskPage.getPageSize());
            } else {
                taskPage.setTotalPage((taskArrayList.size() + 4) / taskPage.getPageSize());
                taskPage.setTotalRecord(taskArrayList.size());
                currentPage = currentPage - 1;
                taskPage.setCurrentPage(currentPage);
                head = currentPage * taskPage.getPageSize() - 4;
                tail = currentPage * taskPage.getPageSize();
                ArrayList<Task> temptaskPage = taskMapper.selectByPage(head, tail);
                taskPage.setDataList(temptaskPage);
            }
        } else {
            taskPage.setTotalPage(0);
            taskPage.setTotalRecord(0);
        }
        return taskPage;
    }

    /*用户按页查找*/
    public Page<Task> selectByPageUser(int currentPage,String uid) {
        Page<Task> taskPage = new Page<Task>();
        int head = currentPage * taskPage.getPageSize() - 4;
        int tail = currentPage * taskPage.getPageSize();
        //获取当前时间
        Date time =new Date();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Task> taskArrayList = taskMapper.selectAllUser(uid,time);
        /*再按页查询，取该页数据*/
       ArrayList<Task> task = taskMapper.selectByPageUser(head, tail, uid, time);
        if (!taskArrayList.isEmpty()) {
            if (!task.isEmpty()) {
                taskPage.setCurrentPage(currentPage);
                taskPage.setDataList(task);
                taskPage.setTotalRecord(taskArrayList.size());
                taskPage.setTotalPage((taskArrayList.size() + 4) / taskPage.getPageSize());
            } else {
                taskPage.setTotalPage((taskArrayList.size() + 4) / taskPage.getPageSize());
                taskPage.setTotalRecord(taskArrayList.size());
                currentPage = currentPage - 1;
                taskPage.setCurrentPage(currentPage);
                head = currentPage * taskPage.getPageSize() - 4;
                tail = currentPage * taskPage.getPageSize();
                ArrayList<Task> temptaskPage = taskMapper.selectByPageUser(head, tail, uid,time);
                taskPage.setDataList(temptaskPage);
            }
        } else {
            taskPage.setTotalPage(0);
            taskPage.setTotalRecord(0);
        }
        return taskPage;
    }

    /*查找一个*/
    public Task selectOne(int tid) {
        return taskMapper.selectOne(tid);
    }

    /*删除*/
    public Res delete(int tid) {
        int result = taskMapper.delete(tid);
        if (result == 1) {
            return new Res("delete success", 200);
        } else {
            return new Res("delete failed", 500);
        }
    }

    public Res update(int tid, String tname, String tdescription, float trequirement, int taward, int ttype, Date tdeadline) {
        int result = taskMapper.update(tname, tdescription, trequirement, taward, ttype, tdeadline, tid);
        if (result == 1) {
            return new Res("update success", 200);
        } else {
            return new Res("update failed", 500);
        }
    }

    //    用户领取任务奖励后更新
    @Transactional
    public Res update_user(String uid, int taward, int tid) {
        //更新用户积分
        taskMapper.update_user(uid, taward);
        //查询Usr_Task表是否存在该任务
        int state = taskMapper.select_Usr_Task(uid, tid);

        // 存在该任务，对任务状态进行更新
        if (state > 0) {
            int result = taskMapper.update_Usr_Task(uid, tid);
            System.out.println(result);
            //获取用户碳积分余额
            String ucintegral = String.valueOf(usrMapper.selectUsrUcintegral(uid));
            if (result == 1) {
                return new Res("成功领取" + taward + "积分,当前账户余额：" + ucintegral, 200);
            } else {
                return new Res("领取失败", 500);
            }
        }
        //不存在该任务，将该任务插入Usr_Task表且将任务状态置为1
        else {
            int insertresult = taskMapper.insert_Usr_Task(uid, tid);
            //获取用户碳积分余额
            String ucintegral = String.valueOf(usrMapper.selectUsrUcintegral(uid));
            if (insertresult == 1) {
                return new Res("成功领取" + taward + "积分,当前账户余额：" + ucintegral, 200);
            } else {
                return new Res("领取失败", 500);
            }
        }
    }

    public Page<Task> selectmytask(String uid, int currentPage) {
        Page<Task> taskPage = new Page<Task>();
        int head = currentPage * taskPage.getPageSize() - taskPage.getPageSize()+1;
        int tail = currentPage * taskPage.getPageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Task> taskArrayList = taskMapper.selectAllfinishtask(uid);
        /*再按页查询，取该页数据*/
        ArrayList<Task> task = taskMapper.selectPagefinishtask(uid,head, tail);
        if (!taskArrayList.isEmpty()) {
            if (!task.isEmpty()) {
                taskPage.setCurrentPage(currentPage);
                taskPage.setDataList(task);
                taskPage.setTotalRecord(taskArrayList.size());
                taskPage.setTotalPage((taskArrayList.size() + taskPage.getPageSize()-1) / taskPage.getPageSize());
            } else {
                taskPage.setTotalPage((taskArrayList.size() + taskPage.getPageSize()-1) / taskPage.getPageSize());
                taskPage.setTotalRecord(taskArrayList.size());
                currentPage = currentPage - 1;
                taskPage.setCurrentPage(currentPage);
                head = currentPage * taskPage.getPageSize() - taskPage.getPageSize()+1;
                tail = currentPage * taskPage.getPageSize();
                ArrayList<Task> temptaskPage = taskMapper.selectPagefinishtask(uid,head, tail);
                taskPage.setDataList(temptaskPage);
            }
        } else {
            taskPage.setTotalPage(0);
            taskPage.setTotalRecord(0);
        }
        return taskPage;
    }
}
