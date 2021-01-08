package com.edu.zjut.service;

import com.edu.zjut.entity.*;
import com.edu.zjut.mapper.BusinessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class BusinessService {
    BusinessMapper businessMapper;

    @Autowired
    public void setBusinessMapper(BusinessMapper businessMapper) {
        this.businessMapper = businessMapper;
    }

    /*商家登录账号*/
    public ResBusiness login(String id, String password){
        Business business=businessMapper.selectlogin(id,password);
        if(business==null){
            return new ResBusiness("登录失败",500,null);
        }
        else
            return new ResBusiness("登录成功",200,business.getBid());
    }

    /*商家注册账号*/
    public Res register(String id, String password){
        int result=businessMapper.register(id,password);
        if(result==1){
            return new Res("注册成功",200);
        }
        else
            return new Res("注册失败",500);
    }

    /*商家修改账号信息*/
    public Res update(String id,String name,String password,String address) {
        int result = businessMapper.update(id, name, password,address);
        if (result == 1) {
            return new Res("修改成功", 200);
        } else
            return new Res("修改失败", 500);
    }

    /*按页搜索 该商家 所有用户配送单信息*/
    public Page<Business_deliver> selectByPage(int currentPage,String bid) {
        Page<Business_deliver> deliverPage = new Page<Business_deliver>();
        int head = currentPage * deliverPage.getPageSize() - 4;
        int tail = currentPage * deliverPage.getPageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Business_deliver> deliverArrayList = businessMapper.selectDeliverAll(bid);
        /*再按页查询，取该页数据*/
        ArrayList<Business_deliver> deliver = businessMapper.selectByPage(head, tail,bid);
        if (!deliverArrayList.isEmpty()) {
            if (!deliver.isEmpty()) {
                deliverPage.setCurrentPage(currentPage);
                deliverPage.setDataList(deliver);
                deliverPage.setTotalRecord(deliverArrayList.size());
                deliverPage.setTotalPage((deliverArrayList.size() + 4) / deliverPage.getPageSize());
            } else {
                deliverPage.setTotalPage((deliverArrayList.size() + 4) / deliverPage.getPageSize());
                deliverPage.setTotalRecord(deliverArrayList.size());
                currentPage = currentPage - 1;
                deliverPage.setCurrentPage(currentPage);
                head = currentPage * deliverPage.getPageSize() - 4;
                tail = currentPage * deliverPage.getPageSize();
                ArrayList<Business_deliver> tempdeliverPage = businessMapper.selectByPage(head, tail,bid);
                deliverPage.setDataList(tempdeliverPage);
            }
        } else {
            deliverPage.setTotalPage(0);
            deliverPage.setTotalRecord(0);
        }
        return deliverPage;
    }

    /*根据gid按页搜索 该商家 所有用户配送单信息*/
    public Page<Business_deliver> selectByGidPage(int currentPage,int gid,String bid,int type) {
        Page<Business_deliver> deliverPage = new Page<Business_deliver>();
        int head = currentPage * deliverPage.getPageSize() - 4;
        int tail = currentPage * deliverPage.getPageSize();
        ArrayList<Business_deliver> deliverArrayList;
        ArrayList<Business_deliver> deliver;
        if(type == 1) {    //未发货商品信息
            /*先整体查询，取数据表整体数据记录数量与页数*/
            deliverArrayList = businessMapper.selectByGidAllState0(gid, bid);
            /*再按页查询，取该页数据*/
            deliver = businessMapper.selectByGidPageState0(head, tail, gid, bid);
        }
        else{              //全部商品信息
            /*先整体查询，取数据表整体数据记录数量与页数*/
            deliverArrayList = businessMapper.selectByGidAll(gid, bid);
            /*再按页查询，取该页数据*/
            deliver = businessMapper.selectByGidPage(head, tail, gid, bid);
        }
        if (!deliverArrayList.isEmpty()) {
            if (!deliver.isEmpty()) {
                deliverPage.setCurrentPage(currentPage);
                deliverPage.setDataList(deliver);
                deliverPage.setTotalRecord(deliverArrayList.size());
                deliverPage.setTotalPage((deliverArrayList.size() + 4) / deliverPage.getPageSize());
            } else {
                deliverPage.setTotalPage((deliverArrayList.size() + 4) / deliverPage.getPageSize());
                deliverPage.setTotalRecord(deliverArrayList.size());
                currentPage = currentPage - 1;
                deliverPage.setCurrentPage(currentPage);
                head = currentPage * deliverPage.getPageSize() - 4;
                tail = currentPage * deliverPage.getPageSize();
                ArrayList<Business_deliver> tempdeliverPage;
                if(type == 1)
                    tempdeliverPage = businessMapper.selectByGidPageState0(head, tail, gid, bid);
                else
                    tempdeliverPage = businessMapper.selectByGidPage(head, tail, gid, bid);
                deliverPage.setDataList(tempdeliverPage);
            }
        } else {
            deliverPage.setTotalPage(0);
            deliverPage.setTotalRecord(0);
        }
        return deliverPage;
    }

    /*根据商品名按页搜索 该商家 所有用户配送单信息-模糊查询*/
    public Page<Business_deliver> selectByNamePage(int currentPage,String gname,String bid,int type) {
        gname ="%"+gname+"%";

        Page<Business_deliver> deliverPage = new Page<Business_deliver>();
        int head = currentPage * deliverPage.getPageSize() - 4;
        int tail = currentPage * deliverPage.getPageSize();
        ArrayList<Business_deliver> deliverArrayList;
        ArrayList<Business_deliver> deliver;
        if(type == 1) {    //未发货商品信息
            /*先整体查询，取数据表整体数据记录数量与页数*/
            deliverArrayList = businessMapper.selectByNameAllState0(gname, bid);
            /*再按页查询，取该页数据*/
            deliver = businessMapper.selectByNamePageState0(head, tail, gname, bid);
        }
        else{              //全部商品信息
            /*先整体查询，取数据表整体数据记录数量与页数*/
            deliverArrayList = businessMapper.selectByNameAll(gname, bid);
            /*再按页查询，取该页数据*/
            deliver = businessMapper.selectByNamePage(head, tail, gname, bid);
        }
        if (!deliverArrayList.isEmpty()) {
            if (!deliver.isEmpty()) {
                deliverPage.setCurrentPage(currentPage);
                deliverPage.setDataList(deliver);
                deliverPage.setTotalRecord(deliverArrayList.size());
                deliverPage.setTotalPage((deliverArrayList.size() + 4) / deliverPage.getPageSize());
            } else {
                deliverPage.setTotalPage((deliverArrayList.size() + 4) / deliverPage.getPageSize());
                deliverPage.setTotalRecord(deliverArrayList.size());
                currentPage = currentPage - 1;
                deliverPage.setCurrentPage(currentPage);
                head = currentPage * deliverPage.getPageSize() - 4;
                tail = currentPage * deliverPage.getPageSize();
                ArrayList<Business_deliver> tempdeliverPage;
                if(type == 1)
                    tempdeliverPage = businessMapper.selectByNamePageState0(head, tail,gname, bid);
                else
                    tempdeliverPage = businessMapper.selectByNamePage(head, tail,gname, bid);
                deliverPage.setDataList(tempdeliverPage);
            }
        } else {
            deliverPage.setTotalPage(0);
            deliverPage.setTotalRecord(0);
        }
        return deliverPage;
    }

    /*更新发货状态*/
    public Res updateDeliver(String uid, int gid) {
        int result = businessMapper.updateDeliver(uid,gid,1);
        if (result == 1) {
            return new Res("发货成功", 200);
        } else {
            return new Res("发货失败", 500);
        }
    }

    /*删除配送单信息*/
    public Res deleteDeliver(String uid, int gid) {
        int result = businessMapper.deleteDeliver(uid,gid);
        if (result == 1) {
            return new Res("删除成功", 200);
        } else {
            return new Res("删除失败", 500);
        }
    }

    /*按页搜索商家上架的所有商品*/
    public Page<Goods> selectGoodsPage(int currentPage,String bid) {
        Page<Goods> goodsPage = new Page<Goods>();
        int head = currentPage * goodsPage.getPageSize() - 4;
        int tail = currentPage * goodsPage.getPageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Goods> goodsArrayList = businessMapper.selectGoodsAll(bid);
        /*再按页查询，取该页数据*/
        ArrayList<Goods> goods = businessMapper.selectGoodsPage(head, tail, bid);
        if (!goodsArrayList.isEmpty()) {
            if (!goods.isEmpty()) {
                goodsPage.setCurrentPage(currentPage);
                goodsPage.setDataList(goods);
                goodsPage.setTotalRecord(goodsArrayList.size());
                goodsPage.setTotalPage((goodsArrayList.size() + 4) / goodsPage.getPageSize());
            } else {
                goodsPage.setTotalPage((goodsArrayList.size() + 4) / goodsPage.getPageSize());
                goodsPage.setTotalRecord(goodsArrayList.size());
                currentPage = currentPage - 1;
                goodsPage.setCurrentPage(currentPage);
                head = currentPage * goodsPage.getPageSize() - 4;
                tail = currentPage * goodsPage.getPageSize();
                ArrayList<Goods> tempGoodsPage = businessMapper.selectGoodsPage(head, tail,bid);
                goodsPage.setDataList(tempGoodsPage);
            }
        } else {
            goodsPage.setTotalPage(0);
            goodsPage.setTotalRecord(0);
        }
        return goodsPage;
    }

    /*查询商家余额*/
    public float selectMoney(String bid) {
        return businessMapper.selectMoney(bid);
    }
}
