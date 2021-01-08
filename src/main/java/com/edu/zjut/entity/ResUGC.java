package com.edu.zjut.entity;

import java.util.ArrayList;

public class ResUGC {
    UsrNoP usrNoP;
    Goods goods;
    ArrayList<Coupon> datalist;

    public ResUGC() {
    }

    public ResUGC(UsrNoP usrNoP, Goods goods, ArrayList<Coupon> datalist) {
        this.usrNoP = usrNoP;
        this.goods = goods;
        this.datalist = datalist;
    }

    public UsrNoP getUsrNoP() {
        return usrNoP;
    }

    public void setUsrNoP(UsrNoP usrNoP) {
        this.usrNoP = usrNoP;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public ArrayList<Coupon> getDatalist() {
        return datalist;
    }

    public void setDatalist(ArrayList<Coupon> datalist) {
        this.datalist = datalist;
    }
}
