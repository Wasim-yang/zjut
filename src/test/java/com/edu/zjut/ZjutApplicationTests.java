package com.edu.zjut;

import com.edu.zjut.mapper.GoodsMapper;
import com.edu.zjut.mapper.UsrMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZjutApplicationTests {
    GoodsMapper goodsMapper;
    UsrMapper usrMapper;

    @Autowired
    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Autowired
    public void setUsrMapper(UsrMapper usrMapper){this.usrMapper=usrMapper;}

    @Test
    public void insertgoods(){
        goodsMapper.insert("ywx",12,12,3213,"123","123");
    }

    @Test
    public void selectpage(){
        System.out.println(goodsMapper.selectpage(2,5));
    }
}
