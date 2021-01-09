package com.edu.zjut.controller;

import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.Task;
import com.edu.zjut.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/3 16:10
 * @description ：
 */
@RestController
public class TaskController {
    TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * 添加任务
     */
    @RequestMapping(path = "/admin/task/insert")
    public Res insert(String tname, String tdescription, float trequirement, int taward, int ttype, Date tstartime,Date tdeadline) {
        return taskService.insert(tname, tdescription, trequirement, taward, ttype, tstartime,tdeadline);
    }

    /**
     * 管理员查询全部
     */
    @RequestMapping(path = "/admin/task/selectByPage")
    public Page<Task> selectByPage(int currentPage) {
        return taskService.selectByPage(currentPage);
    }
    /**
     * 用户查询全部
     */
    @RequestMapping(path = "/usr/task/selectByPageUser")
    public Page<Task> selectByPageUser(int currentPage) {
        return taskService.selectByPageUser(currentPage);
    }

    /**
     * 通过id查询
     */
    @RequestMapping(path = "/admin/task/selectOne")
    public Task selectOne(int tid) {
        return taskService.selectOne(tid);
    }

    /**
     * 删除
     */
    @RequestMapping(path = "/admin/task/delete")
    public Res delete(int tid) {
        return taskService.delete(tid);
    }

    /**
     * 更新
     */
    @RequestMapping(path = "/admin/task/update")
    public Res update(int tid, String tname, String tdescription, float trequirement, int taward, int ttype, Date tdeadline) {
        return taskService.update(tid, tname, tdescription, trequirement, taward, ttype, tdeadline);
    }

//    用户领取任务奖励后，更新
    @RequestMapping(path = "/usr/task/update_user")
    public Res update_user(String uid,int taward,int tid){
        return taskService.update_user(uid,taward,tid);
    }

    @RequestMapping(path = "/usr/task/selectpage")
    public Page<Task> selectpage(String uid,int currentPage){
        return taskService.selectmytask(uid,currentPage);
    }
}
