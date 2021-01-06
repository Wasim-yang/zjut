package com.edu.zjut.entity;

public class ResBusiness {
    String message;
    int code;
    String bid;

    public ResBusiness() {
    }

    public ResBusiness(String message, int code, String bid) {
        this.message = message;
        this.code = code;
        this.bid = bid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
