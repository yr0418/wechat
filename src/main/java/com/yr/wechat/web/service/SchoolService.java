package com.yr.wechat.web.service;

import com.yr.wechat.mybatis.mapper.SchoolMapper;
import com.yr.wechat.mybatis.pojo.Car;
import com.yr.wechat.mybatis.pojo.School;
import com.yr.wechat.web.common.ExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService extends ExtendService<School> {
    @Autowired
    SchoolMapper schoolMapper;

    public String getSchoolNum(String openid){
        return schoolMapper.getschoolNum(openid);
    }

    public List<Car> getCarbySchoolNum(String schoolNum){
        return schoolMapper.getCarbySchoolNum(schoolNum);
    }

    public List<School> selectSchool(String SchoolNum){
        return schoolMapper.selectSchool(SchoolNum);
    }

    public void AddSchool(String SchoolNum,String SchoolName,String SchoolLocation){
        schoolMapper.AddSchool(SchoolNum,SchoolName,SchoolLocation);
    }
}

