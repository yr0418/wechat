package com.yr.wechat.mybatis.mapper;

import com.yr.wechat.mybatis.CustomMapper;
import com.yr.wechat.mybatis.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface NewsMapper extends CustomMapper<News> {
    //设置所有的通知消息状态为“未发布”
    @Update("update news set news_situation = '未发布' where school_num = #{schoolNum}")
    public void UpdateNewsToHide(String schoolNum);

    //根据id修改通知消息状态为“开放”
    @Update("update news set news_situation = '发布' where id = #{id}")
    public void ShowNewsById(String id);

    //根据id查询实例
    @Select("select * from news where id=#{id}")
    public News getNewsById(String id);

    //查询驾校发布的信息
    @Select("select * from news where school_num=#{SchoolNum}")
    public List<News> selectNews(String SchoolNum);
}