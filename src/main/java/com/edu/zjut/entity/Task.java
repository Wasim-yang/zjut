package com.edu.zjut.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ：甘明浩
 * @date ：Created in 2021/1/3 17:20
 * @description ：任务实体类
 */
public class Task {
    int tid;
    String tname;
    String tdescription;
    float trequirement;
    int taward;
    int ttype;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date tdeadline;

    public Task() {
    }

    public Task(int tid, String tname, String tdescription, float trequirement, int taward, int ttype, Date tdeadline) {
        this.tid = tid;
        this.tname = tname;
        this.tdescription = tdescription;
        this.trequirement = trequirement;
        this.taward = taward;
        this.ttype = ttype;
        this.tdeadline = tdeadline;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTdescription() {
        return tdescription;
    }

    public void setTdescription(String tdescription) {
        this.tdescription = tdescription;
    }

    public float getTrequirement() {
        return trequirement;
    }

    public void setTrequirement(float trequirement) {
        this.trequirement = trequirement;
    }

    public int getTaward() {
        return taward;
    }

    public void setTaward(int taward) {
        this.taward = taward;
    }

    public int getTtype() {
        return ttype;
    }

    public void setTtype(int ttype) {
        this.ttype = ttype;
    }
    public Date getTdeadline() {
        return tdeadline;
    }

    public void setTdeadline(Date tdeadline) {
        this.tdeadline = tdeadline;
    }
}
