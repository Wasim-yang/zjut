package com.edu.zjut.service;


import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Res;
import com.edu.zjut.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {
    GoodsMapper goodsMapper;

    @Autowired
    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    public Res insert(String name, float cost, int number, int ean, String description, String path) {
        int result = goodsMapper.insert(name, cost, number, ean, description, path);
        if (result == 1) {
            return new Res("insert success", 200);
        } else
            return new Res("insert failed", 500);
    }

    public ArrayList<Goods> select() {
        return (goodsMapper.select());
    }

    public Res delete(int id) {
        int result = goodsMapper.delete(id);
        if (result == 1) {
            return new Res("delete success", 200);
        } else
            return new Res("delete failed", 500);
    }

    public Res update(int id, String name, float cost, int number, int ean, String description) {
        int result = goodsMapper.update(id, name, cost, number, ean, description);
        if (result == 1) {
            return new Res("update success", 200);
        } else
            return new Res("update failed", 500);
    }
}
