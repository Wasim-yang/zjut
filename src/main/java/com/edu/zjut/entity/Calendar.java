package com.edu.zjut.entity;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/5 17:12
 * @description ：
 */
public class Calendar {
    String uid;
    int caid;
    int caYear;
    int caMonth;
    int caDay;

    public Calendar() {
    }

    public Calendar(String uid, int caid, int caYear, int caMonth, int caDay) {
        this.uid = uid;
        this.caid = caid;
        this.caYear = caYear;
        this.caMonth = caMonth;
        this.caDay = caDay;
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

    public int getCaYear() {
        return caYear;
    }

    public void setCaYear(int caYear) {
        this.caYear = caYear;
    }

    public int getCaMonth() {
        return caMonth;
    }

    public void setCaMonth(int caMonth) {
        this.caMonth = caMonth;
    }

    public int getCaDay() {
        return caDay;
    }

    public void setCaDay(int caDay) {
        this.caDay = caDay;
    }
}
