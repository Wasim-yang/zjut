package com.edu.zjut.entity;

public class Coupon {
    int cid;
    String cname;
    float cdiscount;
    String cdescription;
    int cexpoint;

    public Coupon() {
    }

    public Coupon(int cid, String cname, float cdiscount, String cdescription, int cexpoint) {
        this.cid = cid;
        this.cname = cname;
        this.cdiscount = cdiscount;
        this.cdescription = cdescription;
        this.cexpoint = cexpoint;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public float getCdiscount() {
        return cdiscount;
    }

    public void setCdiscount(float cdiscount) {
        this.cdiscount = cdiscount;
    }

    public String getCdescription() {
        return cdescription;
    }

    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }

    public int getCexpoint() {
        return cexpoint;
    }

    public void setCexpoint(int cexpoint) {
        this.cexpoint = cexpoint;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdiscount=" + cdiscount +
                ", cdescription='" + cdescription + '\'' +
                ", cexpoint=" + cexpoint +
                '}';
    }
}
