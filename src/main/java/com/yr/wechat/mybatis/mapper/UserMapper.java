package com.yr.wechat.mybatis.mapper;

import com.yr.wechat.mybatis.CustomMapper;
import com.yr.wechat.mybatis.pojo.Car;
import com.yr.wechat.mybatis.pojo.News;
import com.yr.wechat.mybatis.pojo.School;
import com.yr.wechat.mybatis.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends CustomMapper<User> {


    //走service 层
    //根据用户的openid查询所在驾校的车辆信息
    @Select("select * from car where car_school_num=(select user_school_num from user where user_num=#{userNum} and car_situation='开放')")
    public List<Car> getCarByUserId(String userNum);

    //根据用户的openid查询所在驾校的通知信息
    @Select("select * from news where school_num=(select user_school_num from user where user_num=#{userNum}) and news_situation='发布'")
    public List<News> getNewsInfo(String userNum);

    //根据用户的openid查询所在驾校的详细信息
    @Select("select * from school where school_num=(select user_school_num from user where user_num=#{userNum})")
    public List<School> SelectSchool(String userNum);

    //确定是否存在该用户
    @Select("select user_num from user where user_num=#{userNum}")
    public String getUserNum(String userNum);

    //查询用户基本信息
    @Select("select * from user where user_num=#{userNum}")
    public User getUser(String userNum);

    //注册学员
    @Insert("insert into user(user_num,user_nickname,user_school_num) values(#{UserNum},#{UserNickname},#{UserSchoolNum})")
    public void AddUser(String UserNum,String UserNickname,String UserSchoolNum);

}