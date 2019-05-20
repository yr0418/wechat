package com.yr.wechat.web.controller;

import com.yr.wechat.mybatis.pojo.*;
import com.yr.wechat.web.common.ExtendController;
import com.yr.wechat.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "User")
public class UserController extends ExtendController<User> {

    //走 service 层
    @Autowired
    UserService userService;


    @ApiOperation(value = "根据学员openid获取对应通知信息")
    @GetMapping(value = "/getNewInfo")
    public List<News> getNewsInfo(String userNum){
        return userService.getNewsInfo(userNum);
    }

    //根据学员openid以及选择的练车时间获取可预约的车辆信息
    @ApiOperation(value = "根据选择的时间段查询车辆信息")
    @GetMapping(value = "/showcar")
    public List<CarSeat> ShowCar(String time, String userNum){
        List<Car> carList=userService.getCarByUserId(userNum);
        List<CarSeat> carSeatList=new ArrayList<>();
        switch (time){
            case "8":
                for (int i = 0; i <carList.size() ; i++) {
                    int num=carList.get(i).getTime8Left();
                    if(num==0){
                        continue;
                    }else {
                        CarSeat carSeat=new CarSeat();
                        carSeat.setCarColor(carList.get(i).getCarColor());
                        carSeat.setCarNum(carList.get(i).getCarNum());
                        carSeat.setCarSchoolNum(carList.get(i).getCarSchoolNum());
                        carSeat.setCarType(carList.get(i).getCarType());
                        carSeat.setMaxseat(carList.get(i).getTime8Max());
                        carSeat.setLeftseat(carList.get(i).getTime8Left());
                        carSeatList.add(carSeat);
                    }
                }
                break;
            case "9":
                for (int i = 0; i <carList.size() ; i++) {
                    int num=carList.get(i).getTime9Left();
                    if(num==0){
                        continue;
                    }else {
                        CarSeat carSeat=new CarSeat();
                        carSeat.setCarColor(carList.get(i).getCarColor());
                        carSeat.setCarNum(carList.get(i).getCarNum());
                        carSeat.setCarSchoolNum(carList.get(i).getCarSchoolNum());
                        carSeat.setCarType(carList.get(i).getCarType());
                        carSeat.setMaxseat(carList.get(i).getTime9Max());
                        carSeat.setLeftseat(carList.get(i).getTime9Left());
                        carSeatList.add(carSeat);
                    }
                }
                break;
            case "10":
                for (int i = 0; i <carList.size() ; i++) {
                    int num=carList.get(i).getTime10Left();
                    if(num==0){
                        continue;
                    }else {
                        CarSeat carSeat=new CarSeat();
                        carSeat.setCarColor(carList.get(i).getCarColor());
                        carSeat.setCarNum(carList.get(i).getCarNum());
                        carSeat.setCarSchoolNum(carList.get(i).getCarSchoolNum());
                        carSeat.setCarType(carList.get(i).getCarType());
                        carSeat.setMaxseat(carList.get(i).getTime10Max());
                        carSeat.setLeftseat(carList.get(i).getTime10Left());
                        carSeatList.add(carSeat);
                    }
                }
                break;
            case "11":
                for (int i = 0; i <carList.size() ; i++) {
                    int num=carList.get(i).getTime11Left();
                    if(num==0){
                        continue;
                    }else {
                        CarSeat carSeat=new CarSeat();
                        carSeat.setCarColor(carList.get(i).getCarColor());
                        carSeat.setCarNum(carList.get(i).getCarNum());
                        carSeat.setCarSchoolNum(carList.get(i).getCarSchoolNum());
                        carSeat.setCarType(carList.get(i).getCarType());
                        carSeat.setMaxseat(carList.get(i).getTime11Max());
                        carSeat.setLeftseat(carList.get(i).getTime11Left());
                        carSeatList.add(carSeat);
                    }
                }
                break;
            case "14":
                for (int i = 0; i <carList.size() ; i++) {
                    int num=carList.get(i).getTime14Left();
                    if(num==0){
                        continue;
                    }else {
                        CarSeat carSeat=new CarSeat();
                        carSeat.setCarColor(carList.get(i).getCarColor());
                        carSeat.setCarNum(carList.get(i).getCarNum());
                        carSeat.setCarSchoolNum(carList.get(i).getCarSchoolNum());
                        carSeat.setCarType(carList.get(i).getCarType());
                        carSeat.setMaxseat(carList.get(i).getTime14Max());
                        carSeat.setLeftseat(carList.get(i).getTime14Left());
                        carSeatList.add(carSeat);
                    }
                }
                break;
            case "15":
                for (int i = 0; i <carList.size() ; i++) {
                    int num=carList.get(i).getTime15Left();
                    if(num==0){
                        continue;
                    }else {
                        CarSeat carSeat=new CarSeat();
                        carSeat.setCarColor(carList.get(i).getCarColor());
                        carSeat.setCarNum(carList.get(i).getCarNum());
                        carSeat.setCarSchoolNum(carList.get(i).getCarSchoolNum());
                        carSeat.setCarType(carList.get(i).getCarType());
                        carSeat.setMaxseat(carList.get(i).getTime15Max());
                        carSeat.setLeftseat(carList.get(i).getTime15Left());
                        carSeatList.add(carSeat);
                    }
                }
                break;
            case "16":
                for (int i = 0; i <carList.size() ; i++) {
                    int num=carList.get(i).getTime16Left();
                    if(num==0){
                        continue;
                    }else {
                        CarSeat carSeat=new CarSeat();
                        carSeat.setCarColor(carList.get(i).getCarColor());
                        carSeat.setCarNum(carList.get(i).getCarNum());
                        carSeat.setCarSchoolNum(carList.get(i).getCarSchoolNum());
                        carSeat.setCarType(carList.get(i).getCarType());
                        carSeat.setMaxseat(carList.get(i).getTime16Max());
                        carSeat.setLeftseat(carList.get(i).getTime16Left());
                        carSeatList.add(carSeat);
                    }
                }
                break;
            case "17":
                for (int i = 0; i <carList.size() ; i++) {
                    int num=carList.get(i).getTime17Left();
                    if(num==0){
                        continue;
                    }else {
                        CarSeat carSeat=new CarSeat();
                        carSeat.setCarColor(carList.get(i).getCarColor());
                        carSeat.setCarNum(carList.get(i).getCarNum());
                        carSeat.setCarSchoolNum(carList.get(i).getCarSchoolNum());
                        carSeat.setCarType(carList.get(i).getCarType());
                        carSeat.setMaxseat(carList.get(i).getTime17Max());
                        carSeat.setLeftseat(carList.get(i).getTime17Left());
                        carSeatList.add(carSeat);
                    }
                }
                break;
        }
        return carSeatList;
    }

    @ApiOperation(value = "根据学员的openid查询所在驾校信息")
    @GetMapping("/selectSchool")
    public List<School> SelectSchool(String userNum){
        return userService.SelectSchool(userNum);
    }
}
