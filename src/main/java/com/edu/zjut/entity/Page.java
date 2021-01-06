package com.edu.zjut.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Page<T> implements Serializable {
    private static int pageSize=5; // 每页显示多少条记录

    private static int usrpageSize=5;//用户界面每页多少条记录

    private int usrcurrentPage; //用户界面当前第几页数据

    private int usrtotalRecord; // 用户一共多少条记录

    private int usrtotalPage; // 一共多少页记录

    private int currentPage; //当前第几页数据

    private int totalRecord; // 一共多少条记录

    private int totalPage; // 一共多少页记录

    private ArrayList<T> dataList; //要显示的数据

    public Page(){ }

    public Page(int currentPage,int usrcurrentPage, int totalRecord,int usrtotalRecord, int totalPage,int usrtotalPage, ArrayList<T> dataList) {
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.dataList = dataList;
        this.usrcurrentPage = usrcurrentPage;
        this.usrtotalPage = usrtotalPage;
        this.usrtotalRecord=usrtotalRecord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getusrcurrentPage() { return usrcurrentPage; }
    public void setusrcurrentPage(int usrcurrentPage) {
        this.usrcurrentPage = usrcurrentPage;
    }
    public int getusrtotalRecord() {
        return usrtotalRecord;
    }
    public void setusrtotalRecord(int usrtotalRecord) {
        this.usrtotalRecord = usrtotalRecord;
    }
    public int getusrtotalPage() {
        return usrtotalPage;
    }
    public void setusrtotalPage(int usrtotalPage) {
        this.usrtotalPage = usrtotalPage;
    }
    public ArrayList<T> getDataList()
    {
        return dataList;
    }
    public void setDataList(ArrayList<T> dataList) {
        this.dataList = dataList;
    }
    public int getusrPageSize() {
        return usrpageSize;
    }
    public void setusrPageSize(int usrpageSize) {
        this.usrpageSize = usrpageSize;
    }

}