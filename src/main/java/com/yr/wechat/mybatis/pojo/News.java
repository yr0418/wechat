package com.yr.wechat.mybatis.pojo;

import javax.persistence.Id;

public class News {
    @Id
    private Long id;

    private String news;

    private String schoolNum;

    private String newsSituation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news == null ? null : news.trim();
    }

    public String getSchoolNum() {
        return schoolNum;
    }

    public void setSchoolNum(String schoolNum) {
        this.schoolNum = schoolNum == null ? null : schoolNum.trim();
    }

    public String getNewsSituation() {
        return newsSituation;
    }

    public void setNewsSituation(String newsSituation) {
        this.newsSituation = newsSituation == null ? null : newsSituation.trim();
    }
}