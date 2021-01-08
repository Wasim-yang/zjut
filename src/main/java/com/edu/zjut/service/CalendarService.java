package com.edu.zjut.service;

import com.edu.zjut.entity.Calendar;
import com.edu.zjut.entity.Res;
import com.edu.zjut.mapper.CalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/5 19:15
 * @description ：
 */
@Service
public class CalendarService {
    @Autowired
    CalendarMapper calendarMapper;

    public ArrayList<Calendar> selectAll(String uid, int cayear, int camonth) {
        return calendarMapper.selectAll(uid, cayear, camonth);
    }

    public Res addCal(String uid, int year, int month, int day) {
        System.out.println(uid);
        int result1 = calendarMapper.addAward(uid);
        int result2 = calendarMapper.insertCal(uid, year, month, day);
        if (result1 == 1 && result2 == 1) {
            return new Res("insertCal success", 200);
        } else {
            return new Res("insertcal failed", 500);
        }
    }

    public ArrayList<Calendar> selectMyform(String uid) {
        return calendarMapper.selectMyform(uid);
    }
}
