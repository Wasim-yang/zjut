package com.edu.zjut.controller;

import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Res;
import com.edu.zjut.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GoodsController {
    GoodsService goodsService;
    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping(path = "/goods/insert")
    public Res insert(String name, float cost , int number , int ean , String description,String path) {
        return goodsService.insert(name, cost , number , ean ,description ,path);
    }

    @RequestMapping(path = "/goods/select")
    public ArrayList<Goods> select(){
        return goodsService.select();
    }

    @RequestMapping(path = "/goods/delete")
    public Res delete(int id){
        return goodsService.delete(id);
    }
    @RequestMapping(path = "/goods/update")
    public Res update(int id, String name, float cost , int number , int ean ,String description){
        return goodsService.update( id, name,cost,number,ean,description);
    }
}
