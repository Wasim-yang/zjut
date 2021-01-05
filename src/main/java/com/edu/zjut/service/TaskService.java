package com.edu.zjut.service;

import com.edu.zjut.entity.Res;
import com.edu.zjut.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.out.println("TaskService-------"+ result);
        if (result == 1) {
            return new Res("insert success", 200);
        } else {
            return new Res("insert failed", 500);
        }
    }
}
