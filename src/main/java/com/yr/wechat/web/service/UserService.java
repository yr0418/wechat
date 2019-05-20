package com.yr.wechat.web.service;

import com.yr.wechat.mybatis.mapper.UserMapper;
import com.yr.wechat.mybatis.pojo.Car;
import com.yr.wechat.mybatis.pojo.News;
import com.yr.wechat.mybatis.pojo.School;
import com.yr.wechat.mybatis.pojo.User;
import com.yr.wechat.web.common.ExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@SuppressWarnings("ALL")
@Service
public class UserService extends ExtendService<User> {

    @Autowired
    UserMapper userMapper;

    public List<Car> getCarByUserId(String userNum){
        return userMapper.getCarByUserId(userNum);
    }

    public List<News> getNewsInfo(String userNum){
        return userMapper.getNewsInfo(userNum);
    }

    public String getUserNum(String openid){
        return userMapper.getUserNum(openid);
    }

    public User getUser(String userNum){
        return userMapper.getUser(userNum);
    }

    public List<School> SelectSchool(String userNum){
        return userMapper.SelectSchool(userNum);
    }
}
