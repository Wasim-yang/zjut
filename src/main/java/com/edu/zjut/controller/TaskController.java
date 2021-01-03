package com.edu.zjut.controller;

import com.edu.zjut.entity.Res;
import com.edu.zjut.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/3 16:10
 * @description ：
 */
@Controller
public class TaskController {
    TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    /*添加任务*/
    @RequestMapping(path = "/taskk/insertt")
    public Res insert(String tname, String tdescription, float trequirement, int taward, int ttype, Date tdeadline) {
        System.out.println("TaskController---------");
        System.out.println("tname" +tname);
        System.out.println(tdescription);
        System.out.println(trequirement);
        return taskService.insert(tname, tdescription, trequirement, taward, ttype, tdeadline);
    }
}
