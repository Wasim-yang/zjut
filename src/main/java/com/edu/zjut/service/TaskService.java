package com.edu.zjut.service;

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
        System.out.println("TaskService-------selectAll" );
        return taskMapper.selectAll();
    }

    public Res delete(int tid) {
        int result = taskMapper.delete(tid);
        System.out.println("TaskService-------delete" );
        if (result == 1) {
            return new Res("task delete success", 200);
        } else {
            return new Res("task delete failed", 500);
        }
    }

    public Res update(int tid,String tname, String tdescription, float trequirement, int taward, int ttype, Date tdeadline) {
        int result = taskMapper.update(tname, tdescription, trequirement, taward, ttype, tdeadline,tid);
        System.out.println("TaskService-------update" );
        if (result == 1) {
            return new Res("task update success", 200);
        } else {
            return new Res("task update failed", 500);
        }
    }
}
