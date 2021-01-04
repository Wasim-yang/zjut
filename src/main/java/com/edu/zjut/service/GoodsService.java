package com.edu.zjut.service;

import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Res;
import com.edu.zjut.mapper.GoodsMapper;
import com.edu.zjut.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

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
    public Goods selectid(int id) {
        return (goodsMapper.selectid(id));
    }

    /*按页查找*/
    public Page<Goods> selectpage(int currentPage) {
        Page<Goods> goodsPage = new Page<Goods>();
        int head=currentPage * goodsPage.getPageSize() - 4;
        int tail=currentPage * goodsPage.getPageSize();
        /*先整体查询，取数据表整体数据记录数量与页数*/
        ArrayList<Goods> goodsArrayList=goodsMapper.selectall();
        /*再按页查询，取该页数据*/
        ArrayList<Goods> goods = goodsMapper.selectpage(head,tail);
        if (!goods.isEmpty()) {
            goodsPage.setCurrentPage(currentPage);
            goodsPage.setDataList(goods);
            goodsPage.setTotalRecord(goodsArrayList.size());
            goodsPage.setTotalPage((goodsArrayList.size()+4)/goodsPage.getPageSize());
        }
        else {
            goodsPage.setTotalPage(0);
            goodsPage.setTotalRecord(0);
        }
        return goodsPage;
    }

    /*删除*/
    public Res delete(int id) {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
        String filepath = goodsMapper.selectid(id).getGimage();
        filepath = filepath.replace("http://localhost:8080/", "");
        /*删除图片文件*/
        FileUtil.deletefile(path, filepath);
        /*删除数据库数据*/
        int result = goodsMapper.delete(id);
        if (result == 1) {
            return new Res("delete success", 200);
        } else
            return new Res("delete failed", 500);
    }

    /*更新*/
    public Res update(int id, String name, float cost, int number, int ean, String description, String path) {
        int result = goodsMapper.update(id, name, cost, number, ean, description, path);
        if (result == 1) {
            return new Res("update success", 200);
        } else
            return new Res("update failed", 500);
    }
}
