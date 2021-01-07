package com.edu.zjut.service;

import com.edu.zjut.entity.Res;
import com.edu.zjut.mapper.TravellogMapper;
import com.edu.zjut.mapper.UsrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TravellogService {
    TravellogMapper travellogMapper;
    @Autowired
    public void setTravellogMapper(TravellogMapper travellogMapper) {
        this.travellogMapper = travellogMapper;
    }
    UsrMapper usrMapper;
    @Autowired
    public void setUsrMapper(UsrMapper usrMapper) {
        this.usrMapper = usrMapper;
    }

    //用户出行里程记录添加
    @Transactional
    public Res insert(String uid, int type, float mileage){
        Date time = new Date();
        int result = travellogMapper.insert(uid, time, type, mileage);
        if (result == 1) {
            int addmileage;
            switch (type){
                case 1:
                    addmileage = (int)(mileage * 2);
                    break;
                case 2:
                    addmileage = (int)(mileage * 1.5);
                    break;
                case 3:
                case 4:
                    addmileage = (int)(mileage * 1.2);
                    break;
                default:
                    return new Res("里程提交失败,类型错误",500 );
            }
            result = usrMapper.updateAddCintegral(uid,addmileage);
            if(result == 1)
                return new Res("里程提交成功,增加"+addmileage+"点碳积分",200);
            else
                return new Res("里程提交失败",500 );
        } else
            return new Res("里程提交失败",500 );
    }
}
