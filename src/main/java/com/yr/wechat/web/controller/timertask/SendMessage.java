package com.yr.wechat.web.controller.timertask;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yr.wechat.mybatis.pojo.Car;
import com.yr.wechat.mybatis.pojo.Reserve;
import com.yr.wechat.web.service.CarService;
import com.yr.wechat.web.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SendMessage {
    @Autowired
    ReserveService reserveService;
    @Autowired
    CarService carService;
    @Autowired
    RestTemplate restTemplate;

    private static String accessToken="0";
    //@Scheduled(cron ="0 45 7,9,13,15,17 * * *" )
    public void getAccess_token() {
        //获取access_token
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx2be7497fc8ee40a0&secret=5896a0e314a0fb15bb6e8a267e72955b";

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        if(responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK){
            String sessionData = responseEntity.getBody();
            JSONObject jsonObj = JSON.parseObject(sessionData);
            accessToken = jsonObj.getString("access_token");
        }
    }

    //@Scheduled(cron ="0 50 7,8,9,10,13,14,15,16 * * *")
    public void run_1(){
        //设置URL
        String url="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" +accessToken;
        //获取要发送信息的用户的信息
        Calendar calendar=Calendar.getInstance();
        int house=calendar.get(Calendar.HOUR_OF_DAY)+1;
        List<Reserve> reserveList=reserveService.getInfobyTime(house);
        //单个发送
        for (int i = 0; i <reserveList.size() ; i++) {
            Message message=new Message();

            //拼接模板信息
            //设置接收信息用户的openid与fromid
            message.setUserNum(reserveList.get(i).getUserNum());
            message.setUserFrom(reserveList.get(i).getUserFrom());
            message.setTemplateNum("V2HvZj3USpJEsd8LfW4sR0WJqe7C7cnZ4mmKfPPN7d4");
            //设置模板信息的DATA
            Map<String,TemplateData> m=new HashMap<>();
            //设置keyword1.DATA 车牌号
            TemplateData keyword1=new TemplateData();
            keyword1.setValue(reserveList.get(i).getCarNum());
            m.put("keyword1",keyword1);

            //设置keyword2.DATA 预约车型
            Car car=carService.getCarInfo(reserveList.get(i).getCarNum());
            String carInfo=car.getCarType()+" "+car.getCarColor();
            TemplateData keyword2=new TemplateData();
            keyword2.setValue(carInfo);
            m.put("keyword2",keyword2);

            //设置预约时间
            TemplateData keyword3=new TemplateData();
            keyword3.setValue("本日"+house+":00");
            m.put("keyword3",keyword3);

            //设置状态
            TemplateData keyword4=new TemplateData();
            keyword4.setValue("距练车开始还剩10分钟，请准备上车。祝您练车愉快！");
            m.put("keyword4",keyword4);

            message.setData(m);

            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, message, String.class);
            System.out.println("小程序推送结果={}"+responseEntity.getBody());

        }
    }

    //@Scheduled(cron = "0 50 8,9,10,11,14,15,14,17 * * *")
    public void run_2(){
        //设置URL
        String url="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=" +accessToken;
        //获取要发送信息的用户的信息
        Calendar calendar=Calendar.getInstance();
        int house=calendar.get(Calendar.HOUR_OF_DAY);
        List<Reserve> reserveList=reserveService.getInfobyTime(house);
        //单个发送
        for (int i = 0; i <reserveList.size() ; i++) {
            if (reserveList.get(i).getSituation().equals("正在练车")) {
                Message message=new Message();
                //拼接模板信息
                //设置接收信息用户的openid与fromid
                message.setUserNum(reserveList.get(i).getUserNum());
                message.setUserFrom(reserveList.get(i).getUserFrom());
                message.setTemplateNum("j9FLqCojunMm88LaRfNSwVdrbm70rV5fe7z9OD_J9Uk");
                //设置模板信息的DATA
                Map<String,TemplateData> m=new HashMap<>();
                //设置keyword1.DATA 预约时间
                TemplateData keyword1=new TemplateData();
                keyword1.setValue("今日"+house+":00");
                m.put("keyword1",keyword1);

                //设置keyword2.DATA 预约车型
                TemplateData keyword2=new TemplateData();
                keyword2.setValue("今日"+(house+1)+":00");
                m.put("keyword2",keyword2);

                //设置提示
                TemplateData keyword3=new TemplateData();
                keyword3.setValue("还有10分钟本次练车就结束啦，请及时将车辆驾驶至停车处");
                m.put("keyword4",keyword3);
                message.setData(m);

                ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, message, String.class);
                System.out.println("小程序推送结果={}"+responseEntity.getBody());

                reserveService.UpdateSituationToFinsh(reserveList.get(i).getUserNum());
            }


        }
    }
}
