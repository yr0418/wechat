package com.yr.wechat.web.service;

import com.yr.wechat.mybatis.mapper.NewsMapper;
import com.yr.wechat.mybatis.pojo.News;
import com.yr.wechat.web.common.ExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService extends ExtendService<News> {
    @Autowired
    NewsMapper newsMapper;

    public void UpdateNewsToHide(String schoolNum){
        newsMapper.UpdateNewsToHide(schoolNum);
    }

    public void ShowNewsById(String id){
        newsMapper.ShowNewsById(id);
    }

    public News getNewsById(String id){
        return newsMapper.getNewsById(id);
    }

    public List<News> selectNews(String SchoolNum){
        return newsMapper.selectNews(SchoolNum);
    }
}
