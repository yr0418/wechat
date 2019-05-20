package com.yr.wechat.web.controller.timertask;


import java.util.Map;
public class Message {
    private  String userNum;//用户openid
    private  String userFrom;//用户fromid
    private  String templateNum;//模板信息id
    private Map<String, TemplateData> data;//推送文字

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getTemplateNum() {
        return templateNum;
    }

    public void setTemplateNum(String templateNum) {
        this.templateNum = templateNum;
    }

    public Map<String, TemplateData> getData() {
        return data;
    }

    public void setData(Map<String, TemplateData> data) {
        this.data = data;
    }
}
