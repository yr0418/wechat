package com.yr.wechat.web.controller;

import com.yr.wechat.mybatis.pojo.Car;
import com.yr.wechat.mybatis.pojo.Reserve;
import com.yr.wechat.mybatis.pojo.User;
import com.yr.wechat.mybatis.pojo.UserReserve;
import com.yr.wechat.web.common.ExtendController;
import com.yr.wechat.web.service.CarService;
import com.yr.wechat.web.service.ReserveService;
import com.yr.wechat.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;


@Component
@RestController
@RequestMapping(value = "Reserve")
public class ReserveController extends ExtendController<Reserve> {
   @Scheduled(cron = "0 0 19 * * *")
    public void delete(){
        deleteAll();
    }
    @Autowired
    ReserveService reserveService;

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @ApiOperation(value = "判断用户是否预约")
    @GetMapping(value = "YN")
    public String YN(String UserNum){
        int YN=reserveService.UserYNForReserve(UserNum);
        if (YN == 0) {
            return "no";
        }else {
            return "yes";
        }
    }

    @ApiOperation(value = "根据openid获取用户预约信息")
    @GetMapping(value = "/getReserve")
    public UserReserve getReserve(String userNum){
        int YN=reserveService.UserYNForReserve(userNum);
        if(YN!=0){
        Reserve reserve=reserveService.getReserveByUserNum(userNum);
        int c=carService.CarYN(reserve.getCarNum());
        if(c!=0){
        Car car=carService.getCarInfo(reserve.getCarNum());
        UserReserve userReserve =new UserReserve();
        userReserve.setCarColor(car.getCarColor());
        userReserve.setCarNum(car.getCarNum());
        userReserve.setCarSubject(car.getCarSubject());
        userReserve.setCarType(car.getCarType());
        userReserve.setTime(reserve.getTime());
        userReserve.setUserNickname(reserve.getUserNickname());
        userReserve.setUserSituation(reserve.getSituation());
        return userReserve;
        }else {
            return null;
        }
        }else {
            return null;
        }
    }

    //完成预约操作
    @ApiOperation(value = "完成预约操作")
    @PutMapping(value = "/AddReserve")
    public String AddReserve(String userNum,String CarNum,String userFrom,String time){
        String YN=YN(userNum);
        if(YN.equals("no")){
            int count=userService.UserYN(userNum);
            int c=carService.CarYN(CarNum);
            if (count!=0 && c!=0){
            User user =userService.getUser(userNum);
            Reserve reserve=new Reserve();
            reserve.setCarNum(CarNum);
            reserve.setSituation("已预约");
            reserve.setTime(Integer.parseInt(time));
            reserve.setUserNickname(user.getUserNickname());
            reserve.setUserNum(userNum);
            reserve.setUserFrom(userFrom);
            reserveService.add(reserve);
            switch (time){
                case "8":carService.UpdateTime8(CarNum);break;
                case "9":carService.UpdateTime9(CarNum);break;
                case "10":carService.UpdateTime10(CarNum);break;
                case "11":carService.UpdateTime11(CarNum);break;
                case "14":carService.UpdateTime14(CarNum);break;
                case "15":carService.UpdateTime15(CarNum);break;
                case "16":carService.UpdateTime16(CarNum);break;
                case "17":carService.UpdateTime17(CarNum);break;
            }
            return "ok";
            }else {
                return "no";
            }
        }else {
            return "no";
        }
    }

    @ApiOperation(value = "取消预约操作")
    @PutMapping(value = "/delectReserve")
    public String delectReserve(String userNum){
        String YN=YN(userNum);
        if(YN.equals("yes")){
            Reserve reserve=reserveService.getReserveByUserNum(userNum);
            reserveService.deletereserve(userNum);
            int time=reserve.getTime();
            String CarNum=reserve.getCarNum();
            switch (time){
                case 8 :carService.UpdateTime8Add(CarNum);break;
                case 9 :carService.UpdateTime9Add(CarNum);break;
                case 10 :carService.UpdateTime10Add(CarNum);break;
                case 11 :carService.UpdateTime11Add(CarNum);break;
                case 14 :carService.UpdateTime14Add(CarNum);break;
                case 15 :carService.UpdateTime15Add(CarNum);break;
                case 16 :carService.UpdateTime16Add(CarNum);break;
                case 17 :carService.UpdateTime17Add(CarNum);break;
            }
            return "ok";
        }
        return "no";
    }

    @ApiOperation(value = "用户改签操作")
    @PutMapping(value = "/updatetime")
    public String UpdateTime(String userNum,int time){
        String YN=YN(userNum);
        if (YN.equals("yes")){
            Reserve reserve=reserveService.getReserveByUserNum(userNum);
            int oldtime=reserve.getTime();
            String CarNum=reserve.getCarNum();
            switch (oldtime){
                case 8 :carService.UpdateTime8Add(CarNum);break;
                case 9 :carService.UpdateTime9Add(CarNum);break;
                case 10 :carService.UpdateTime10Add(CarNum);break;
                case 11 :carService.UpdateTime11Add(CarNum);break;
                case 14 :carService.UpdateTime14Add(CarNum);break;
                case 15 :carService.UpdateTime15Add(CarNum);break;
                case 16 :carService.UpdateTime16Add(CarNum);break;
                case 17 :carService.UpdateTime17Add(CarNum);break;
            }
            reserveService.UpdateTime(userNum, time);
            switch (time){
                case 8 :carService.UpdateTime8(CarNum);break;
                case 9 :carService.UpdateTime9(CarNum);break;
                case 10 :carService.UpdateTime10(CarNum);break;
                case 11 :carService.UpdateTime11(CarNum);break;
                case 14 :carService.UpdateTime14(CarNum);break;
                case 15 :carService.UpdateTime15(CarNum);break;
                case 16 :carService.UpdateTime16(CarNum);break;
                case 17 :carService.UpdateTime17(CarNum);break;
            }
            return "yes";
        }else {
            return "no";
        }

    }

    @ApiOperation(value = "判断用户是否能改签")
    @GetMapping(value = "/UpdateTimeYN")
    public String UpdateTimeYN(String userNum){
     Reserve reserve=reserveService.getReserveByUserNum(userNum);
     if (reserve.getSituation().equals("已预约")){
         Calendar calendar=Calendar.getInstance();
         int house=calendar.get(Calendar.HOUR_OF_DAY);
         if(house<reserve.getTime()){
             if(house==reserve.getTime()-1){
                 int minute=calendar.get(Calendar.MINUTE);
                 if(minute>=35){
                     return "no";
                 }else {
                     return "yes";
                 }
             }else {
                 return "yes";
             }
         }else {
             return "no";
         }
     }else {
         return "no";
     }
    }

    @ApiOperation(value = "修改用户状态为“正在练车")
    @PutMapping(value = "/UpdateSituation")
    public String UpdateSituation(String userNum){
        Calendar calendar=Calendar.getInstance();
        int house=calendar.get(Calendar.HOUR_OF_DAY);
        Reserve reserve=reserveService.getReserveByUserNum(userNum);
        if(reserve.getTime()==house) {
            reserveService.UpdateSituation(userNum);
            return "ok";
        }else {
            return "no";
        }
    }
}
