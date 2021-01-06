package com.edu.zjut.entity;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/5 17:12
 * @description ：
 */
public class Calendar {
    String uid;
    int caid;
    int cayear;
    int camonth;
    int caday;

    public Calendar() {
    }

    public Calendar(String uid, int caid, int cayear, int camonth, int caday) {
        this.uid = uid;
        this.caid = caid;
        this.cayear = cayear;
        this.camonth = camonth;
        this.caday = caday;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getCaid() {
        return caid;
    }

    public void setCaid(int caid) {
        this.caid = caid;
    }

    public int getCayear() {
        return cayear;
    }

    public void setCayear(int cayear) {
        this.cayear = cayear;
    }

    public int getCamonth() {
        return camonth;
    }

    public void setCamonth(int camonth) {
        this.camonth = camonth;
    }

    public int getCaday() {
        return caday;
    }

    public void setCaday(int caday) {
        this.caday = caday;
    }
}
