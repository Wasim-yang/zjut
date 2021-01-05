package com.edu.zjut.controller;

import com.edu.zjut.entity.Calendar;
import com.edu.zjut.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/5 18:47
 * @description ：
 */
@RestController
public class CalendarController {
    @Autowired
    CalendarService calendarService;
    @RequestMapping("/cal/selectAll")
    public ArrayList<Calendar> selectAll(String uid, int year, int month){
        return calendarService.selectAll(uid, year, month);
    }
}
