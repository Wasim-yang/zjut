package com.edu.zjut.service;

import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.Task;
import com.edu.zjut.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    public void setTaskMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    /*添加*/
    public Res insert(String tname, String tdescription, float trequirement, int taward, int ttype, Date tdeadline) {
        int result = taskMapper.insert(tname, tdescription, trequirement, taward, ttype, tdeadline);
        System.out.println("TaskService-------" + result);
        if (result == 1) {
            return new Res("task insert success", 200);
        } else {
            return new Res("task insert failed", 500);
        }
    }

    /*查找全部*/
    public ArrayList<Task> selectAll() {
        System.out.println("TaskService-------selectAll");
        ArrayList<Task> tasks = taskMapper.selectAll();
        Date tdeadline = tasks.get(0).getTdeadline();
        System.out.println(tdeadline);
        return taskMapper.selectAll();
    }

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

    /*查找一个*/
    public Task selectOne(int tid) {
        System.out.println("TaskService-------selectOne");
        return taskMapper.selectOne(tid);
    }

    public Res delete(int tid) {
        int result = taskMapper.delete(tid);
        System.out.println("TaskService-------delete");
        if (result == 1) {
            return new Res("task delete success", 200);
        } else {
            return new Res("task delete failed", 500);
        }
    }

    public Res update(int tid, String tname, String tdescription, float trequirement, int taward, int ttype, Date tdeadline) {
        int result = taskMapper.update(tname, tdescription, trequirement, taward, ttype, tdeadline, tid);
        System.out.println("TaskService-------update");
        if (result == 1) {
            return new Res("task update success", 200);
        } else {
            return new Res("task update failed", 500);
        }
    }
}
