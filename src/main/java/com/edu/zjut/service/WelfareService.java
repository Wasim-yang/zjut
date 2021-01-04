package com.edu.zjut.service;

import com.edu.zjut.entity.Goods;
import com.edu.zjut.entity.Page;
import com.edu.zjut.entity.Welfare;
import com.edu.zjut.entity.Res;
import com.edu.zjut.mapper.WelfareMapper;
import com.edu.zjut.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;


import java.io.IOException;
import java.util.ArrayList;


@Service
public class WelfareService {

    WelfareMapper welfareMapper;

    @Autowired
    public void setWelfareMapper(WelfareMapper welfareMapper) {
        this.welfareMapper = welfareMapper;
    }
    /*添加*/
    public Res insert( String wname, String wdescription,int wtotal) {
        int result = welfareMapper.insert(wname, wdescription, wtotal);
        if (result == 1) {
            return new Res("insert success", 200);
        } else
            return new Res("insert failed", 500);
    }
    /*按id查找*/
    public Welfare selectid(int wid){return (welfareMapper.selectid(wid));}

//    /*查找*/
//    public ArrayList<Welfare> select() { return (welfareMapper.select()); }
    /*查找*/
    public Page<Welfare> selectpage(int currentPage) {
        Page<Welfare> welfarePage = new Page<Welfare>();
        int head=currentPage*welfarePage.getPageSize()-4;
        int tail=currentPage*welfarePage.getPageSize();
        ArrayList<Welfare> welfareArrayList=welfareMapper.selectall();
        ArrayList<Welfare> welfare = welfareMapper.selectpage(head,tail);
        if (!welfare.isEmpty()) {
            welfarePage.setCurrentPage(currentPage);
            welfarePage.setDataList(welfare);
            welfarePage.setTotalRecord(welfareArrayList.size());
            welfarePage.setTotalPage((welfareArrayList.size()+4)/welfarePage.getPageSize());
        }
        else
        {
            welfarePage.setTotalPage(0);
            welfarePage.setTotalRecord(0);
        }
        return welfarePage;
    }

    /*删除*/
    public Res delete(int wid) {
//        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
//        String filepath=goodsMapper.selectid(id).getPath();
//        filepath=filepath.replace("http://localhost:8080/","");
//        /*删除图片文件*/
//        FileUtil.deletefile(path,filepath);
//        /*删除数据库数据*/
        int result = welfareMapper.delete(wid);
        if (result == 1) {
            return new Res("delete success", 200);
        } else
            return new Res("delete failed", 500);
    }

    /*更新*/
    public Res update(int wid, String wname, String wdescription, int wtotal, int wgain) {
        int result = welfareMapper.update(wid, wname, wdescription, wtotal, wgain );
        if (result == 1) {
            return new Res("update success", 200);
        } else
            return new Res("update failed", 500);
    }

}
