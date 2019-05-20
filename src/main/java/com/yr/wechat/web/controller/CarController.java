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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void UpdataCarByCarNum(String time8Max,String time9Max,String time10Max,String time11Max,String time14Max,String time15Max,String time16Max,String time17Max,String carSubject,String saveSeat,String CarNum){
        carService.UpdataCarSeatByCarNum(time8Max,time9Max,time10Max,time11Max,time14Max,time15Max,time16Max,time17Max,carSubject,saveSeat,CarNum);
    }

    @ApiOperation(value = "设置车辆最大座位数，不分时间段")
    @PutMapping(value = "/SetCarSeat")
    public void SetCarSeat(String MaxSeat,String carSubject,String saveSeat,String CarNum){
        carService.SetCarSeat(MaxSeat,carSubject,saveSeat,CarNum);
    }

    @ApiOperation(value = "修改指定车辆的基本信息")
    @PutMapping(value = "/UpdataCarInfoByCarNum")
    public void UpdataCarInfoByCarNum(String carColor,String carType,String carNum){
        carService.UpdateCarInfoByCarNum(carColor,carType,carNum);
    }

    @ApiOperation(value = "根据车牌号查询车辆信息")
    @GetMapping(value = "/getCarInfo")
    public Car getCarInfo(String carNum){
       return carService.getCarInfo(carNum);
    }
}
