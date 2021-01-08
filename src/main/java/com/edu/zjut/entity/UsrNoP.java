package com.edu.zjut.entity;

/*无密码信息用户实体*/
public class UsrNoP {
    String uid;
    String uname;
    int usex;
    int uage;
    String uaddress;
    int ucintegral;
    float umoney;
    public UsrNoP() {
    }

    public UsrNoP(String uid, String uname, int usex, int uage, String uaddress, int ucintegral, float umoney) {
        this.uid = uid;
        this.uname = uname;
        this.usex = usex;
        this.uage = uage;
        this.uaddress = uaddress;
        this.ucintegral = ucintegral;
        this.umoney = umoney;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUsex() {
        return usex;
    }

    public void setUsex(int usex) {
        this.usex = usex;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public int getUcintegral() {
        return ucintegral;
    }

    public void setUcintegral(int ucintegral) {
        this.ucintegral = ucintegral;
    }

    public float getUmoney() {
        return umoney;
    }

    public void setUmoney(float umoney) {
        this.umoney = umoney;
    }

    @Override
    public String toString() {
        return "UsrNoP{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", usex=" + usex +
                ", uage=" + uage +
                ", uaddress='" + uaddress + '\'' +
                ", ucintegral=" + ucintegral +
                ", umoney=" + umoney +
                '}';
    }
}
