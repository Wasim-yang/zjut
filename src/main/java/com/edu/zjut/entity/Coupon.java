package com.edu.zjut.entity;

public class Coupon {
    int cid;
    String cname;
    float cdiscount;
    int cexpoints;
    String cdescription;

    public Coupon() {}

    public Coupon(int id, String name, float discount, int expoints, String description) {
        this.cid = cid;
        this.cname = cname;
        this.cdiscount = cdiscount;
        this.cexpoints = cexpoints;
        this.cdescription = cdescription;
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

    public int getCexpoints() {
        return cexpoints;
    }

    public void setCexpoints(int cexpoints) {
        this.cexpoints = cexpoints;
    }

    public String getCdescription() {
        return cdescription;
    }

    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }

    @Override
    public String toString() {
        return "Coupons{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdiscount=" + cdiscount +
                ", cexpoints=" + cexpoints +
                ", cdescription='" + cdescription + '\'' +
                '}';
    }
}
