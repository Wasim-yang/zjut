package com.edu.zjut.controller;

import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Res;
import com.edu.zjut.entity.UsrPage;
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
    @RequestMapping(path = "/admin/goods/insert")
    public Res admin_insert(String name, float cost , int number , int ean , String description, String path) {
        return goodsService.insert(name, cost , number , ean ,description ,path);
    }

    /*查询*/
    @RequestMapping(path = "/usr/goods/selectpage")
    public Page<Goods> usr_select(int currentPage){ return goodsService.selectpage(currentPage); }

    @RequestMapping(path = "/admin/goods/selectpage")
    public Page<Goods> admin_select(int currentPage){ return goodsService.selectpage(currentPage); }

    @RequestMapping(path = "/usr/goods/selectpage")
    public UsrPage<Goods> usr_select(int currentPage){ return goodsService.selectUsrpage(currentPage); }

    /*按id查询*/
    @RequestMapping(path="/admin/goods/selectid")
    public Goods admin_selectid(int id){return goodsService.selectid(id);}

    @RequestMapping(path="/usr/goods/selectid")
    public Goods usr_selectid(int id){return goodsService.selectid(id);}

    /*删除*/
    @RequestMapping(path = "/admin/goods/delete")
    public Res admin_delete(int id){ return goodsService.delete(id); }

    /*更新*/
    @RequestMapping(path = "/admin/goods/update")
    public Res update(int id, String name, float cost , int number , int ean ,String description,String path){
        return goodsService.update( id, name, cost, number, ean, description, path);
    }

    @RequestMapping(path = "/usr/goods/selectname")
    public UsrPage<Goods> usr_selectname(String name,int currentPage){
        return goodsService.selectnamepage(name,currentPage);
    }
}
