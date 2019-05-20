package com.yr.wechat.mybatis.mapper;

import com.yr.wechat.mybatis.CustomMapper;
import com.yr.wechat.mybatis.pojo.Car;
import com.yr.wechat.mybatis.pojo.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchoolMapper extends CustomMapper<School> {
    //判断驾校表中是否存在该用户
    @Select("select school_num from school where school_num=#{schoolNum}")
    public String getschoolNum(String schoolNum);

    //根据驾校的openid查询车辆信息
    @Select("select * from car where car_school_num=#{schoolNum}")
    public List<Car> getCarbySchoolNum(String schoolNum);

    //根据驾校的openid查询驾校信息
    @Select("select * from school where school_num=#{SchoolNum}")
    public List<School> selectSchool(String SchoolNum);
}