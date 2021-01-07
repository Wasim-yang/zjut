package com.edu.zjut.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Page<T> implements Serializable {
    private static int pageSize=5; // 每页显示多少条记录

    private static int usrpageSize=5;//用户界面每页多少条记录

    private static int usrmypageSize=5;//用户优惠券界面每页多少条记录

    private int usrcurrentPage; //用户界面当前第几页数据

    private int usrtotalRecord; // 用户一共多少条记录

    private int usrtotalPage; // 用户界面一共多少页记录

    private int usrmycurrentPage; //用户优惠券界面当前第几页数据

    private int usrmytotalRecord; // 用户优惠券界面一共多少条记录

    private int usrmytotalPage; // 用户优惠券界面一共多少页记录

    private int currentPage; //当前第几页数据

    private int totalRecord; // 一共多少条记录

    private int totalPage; // 一共多少页记录

    private ArrayList<T> dataList; //要显示的数据

    public Page(){ }


    public Page(int currentPage, int usrcurrentPage, int totalRecord, int usrtotalRecord, int totalPage, int usrtotalPage,
                int usrmycurrentPage,int usrmytotalRecord,int usrmytotalPage, ArrayList<T> dataList) {
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.dataList = dataList;
        this.usrcurrentPage = usrcurrentPage;
        this.usrtotalPage = usrtotalPage;
        this.usrtotalRecord=usrtotalRecord;
        this.usrmycurrentPage = usrmycurrentPage;
        this.usrmytotalRecord = usrmytotalRecord;
        this.usrmytotalPage = usrmytotalPage;
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

    public int getusrmypageSize() {
        return usrmypageSize;
    }

    public void setusrmypageSize(int usrmypageSize) {
        this.usrmypageSize = usrmypageSize;
    }

    public int getusrmycurrentPage() {
        return usrmycurrentPage;
    }

    public void setusrmycurrentPage(int usrmycurrentPage) {
        this.usrmycurrentPage = usrmycurrentPage;
    }

    public int getusrmytotalRecord() {
        return usrmytotalRecord;
    }

    public void setusrmytotalRecord(int usrmytotalRecord) {
        this.usrmytotalRecord = usrmytotalRecord;
    }

    public int getusrmytotalPage() {
        return usrmytotalPage;
    }

    public void setusrmytotalPage(int usrmytotalPage) {
        this.usrmytotalPage = usrmytotalPage;
    }
}