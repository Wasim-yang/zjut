package com.edu.zjut.service;

import com.edu.zjut.entity.Calendar;
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

    public ArrayList<Calendar> selectAll(String uid,int cayear,int caday){
        return calendarMapper.selectAll(uid, cayear, caday);
    }
}
