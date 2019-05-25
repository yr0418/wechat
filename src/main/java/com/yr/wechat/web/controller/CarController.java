package com.yr.wechat.web.controller;

import com.yr.wechat.mybatis.pojo.Car;
import com.yr.wechat.mybatis.pojo.CarSeat;
import com.yr.wechat.web.common.ExtendController;
import com.yr.wechat.web.common.QueryParameter;
import com.yr.wechat.web.service.CarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping(value = "Car")
public class CarController extends ExtendController<Car> {
    @Autowired
    CarService carService;

    //重置车辆信息
   @Scheduled(cron = "0 0 19 * * *")
    public void UpdateCar() {
        carService.updateCar();
    }


    @ApiOperation(value = "自定义指定车辆的座位信息")
    @PutMapping(value = "/updataCarbyCarNum")
    public String UpdataCarByCarNum(String time8Max,String time9Max,String time10Max,String time11Max,String time14Max,String time15Max,String time16Max,String time17Max,String carSubject,String saveSeat,String CarNum){
       int YN=carService.CarYN(CarNum);
       if(YN!=0){
        carService.UpdataCarSeatByCarNum(time8Max,time9Max,time10Max,time11Max,time14Max,time15Max,time16Max,time17Max,carSubject,saveSeat,CarNum);
        return "ok";
       }else {
           return "no";
       }
    }

    @ApiOperation(value = "设置车辆最大座位数，不分时间段")
    @PutMapping(value = "/SetCarSeat")
    public String  SetCarSeat(String MaxSeat,String carSubject,String saveSeat,String CarNum){
       int YN=carService.CarYN(CarNum);
       if(YN!=0){
        carService.SetCarSeat(MaxSeat,carSubject,saveSeat,CarNum);
        return "ok";
       }else{
           return "no";
       }
    }

    @ApiOperation(value = "修改指定车辆的基本信息")
    @PutMapping(value = "/UpdataCarInfoByCarNum")
    public String UpdataCarInfoByCarNum(String carColor,String carType,String carNum){
        int YN=carService.CarYN(carNum);
        if(YN!=0){
        carService.UpdateCarInfoByCarNum(carColor,carType,carNum);
        return "ok";
        }else {
            return "no";
        }
    }

    @ApiOperation(value = "根据车牌号查询车辆信息")
    @GetMapping(value = "/getCarInfo")
    public Car getCarInfo(String carNum){
       return carService.getCarInfo(carNum);
    }

    @ApiOperation(value = "增加车辆")
    @PostMapping(value = "/AddCar")
    public String addCar(String CarNum,String CarSchoolNum,String CarColor,String CarType){
        int YN=carService.CarYN(CarNum);
       if (YN==0){
           carService.addCar(CarNum,CarSchoolNum,CarColor,CarType);
           return "yes";
       }else {
           return "no";
       }
    }
}
