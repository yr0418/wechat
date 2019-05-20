package com.yr.wechat.web.service;

import com.yr.wechat.mybatis.mapper.ReserveMapper;
import com.yr.wechat.mybatis.pojo.Reserve;
import com.yr.wechat.web.common.ExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService extends ExtendService<Reserve> {
    @Autowired
    ReserveMapper reserveMapper;

    public String getUserNum(String UserNum){
        return reserveMapper.getUseropenid(UserNum);
    }

    public void deletereserve(String userNum){
        reserveMapper.deletereserve(userNum);
    }

    public Reserve getReserveByUserNum(String userNum){
       return reserveMapper.getReserveByUserNum(userNum);
    }

    public List<Reserve> getInfobyTime(int time){
        return reserveMapper.getInfobyTime(time);
    }

    public void UpdateTime(String userNum,int time){
        reserveMapper.UpdateTime(userNum, time);
    }

    public void UpdateSituation(String userNum){
        reserveMapper.UpdateSituation(userNum);
    }
    public void UpdateSituationToFinsh(String userNum){
        reserveMapper.UpdateSituationToFinsh(userNum);
    }

    public List<Reserve> carReserveInfo(String carNum){
        return reserveMapper.carReserveInfo(carNum);
    }
}
