package com.yr.wechat.web.controller;

import com.yr.wechat.mybatis.pojo.News;
import com.yr.wechat.web.common.ExtendController;
import com.yr.wechat.web.service.NewsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping(value = "News")
public class NewsController extends ExtendController<News> {
    @Autowired
    NewsService newsService;

   @Scheduled(cron = "0 0 19 * * *")
    public void delete(){
        deleteAll();
    }

    //添加最新通知消息并发布
    @ApiOperation(value = "添加最新通知消息并发布")
    @PutMapping(value = "/addnews")
    public String AddNews(String schoolNum,String news){
        newsService.UpdateNewsToHide(schoolNum);
        News news1=new News();
        news1.setNews(news);
        news1.setSchoolNum(schoolNum);
        news1.setNewsSituation("发布");
        newsService.add(news1);
        return "ok";
    }

    //发布指定的通知信息
    @ApiOperation(value = "发布指定的通知信息")
    @PutMapping(value = "/showNews")
    public String showNews(String id){
       News news=newsService.getNewsById(id);
        newsService.UpdateNewsToHide(news.getSchoolNum());
        newsService.ShowNewsById(id);
        return "ok";
    }

    @ApiOperation(value = "查询驾校发布过的所有通知信息")
    @GetMapping("/SelectNews")
    public List<News> selectNews(String SchoolNum){
        return newsService.selectNews(SchoolNum);
    }
}
