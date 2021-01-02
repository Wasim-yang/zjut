package com.edu.zjut.service;

import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Res;
import com.edu.zjut.mapper.GoodsMapper;
import com.edu.zjut.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;


import java.io.IOException;
import java.util.ArrayList;


@Service
public class GoodsService {
    GoodsMapper goodsMapper;

    @Autowired
    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }
    /*添加*/
    public Res insert(String name, float cost, int number, int ean, String description, String path) {
        int result = goodsMapper.insert(name, cost, number, ean, description, path);
        if (result == 1) {
            return new Res("insert success", 200);
        } else
            return new Res("insert failed", 500);
    }
    /*按id查找*/
    public Goods selectid(int id){return (goodsMapper.selectid(id));}

    /*查找*/
    public ArrayList<Goods> select() { return (goodsMapper.select()); }

    /*删除*/
    public Res delete(int id) {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
        String filepath=goodsMapper.selectid(id).getPath();
        filepath=filepath.replace("http://localhost:8080/","");
        /*删除图片文件*/
        FileUtil.deletefile(path,filepath);
        /*删除数据库数据*/
        int result = goodsMapper.delete(id);
        if (result == 1) {
            return new Res("delete success", 200);
        } else
            return new Res("delete failed", 500);
    }

    /*更新*/
    public Res update(int id, String name, float cost, int number, int ean, String description,String path) {
        int result = goodsMapper.update(id, name, cost, number, ean, description, path);
        if (result == 1) {
            return new Res("update success", 200);
        } else
            return new Res("update failed", 500);
    }
}
