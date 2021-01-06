package com.edu.zjut.controller;

import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Res;
import com.edu.zjut.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GoodsController {
    GoodsService goodsService;

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    /*添加*/
    @RequestMapping(path = "/goods/insert")
    public Res insert(String name, float cost , int number , int ean , String description, String path) {
        return goodsService.insert(name, cost , number , ean ,description ,path);
    }
    /*查询*/
    @RequestMapping(path = "/goods/selectpage")
    public Page<Goods> select(int currentPage){ return goodsService.selectpage(currentPage); }

    /*按id查询*/
    @RequestMapping(path="/goods/selectid")
    public Goods selectid(int id){return goodsService.selectid(id);}

    /*删除*/
    @RequestMapping(path = "/goods/delete")
    public Res delete(int id){ return goodsService.delete(id); }

    /*更新*/
    @RequestMapping(path = "/goods/update")
    public Res update(int id, String name, float cost , int number , int ean ,String description,String path){
        return goodsService.update( id, name, cost, number, ean, description, path);
    }
}
