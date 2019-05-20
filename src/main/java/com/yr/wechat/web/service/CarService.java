package com.yr.wechat.web.service;

import com.yr.wechat.mybatis.mapper.CarMapper;
import com.yr.wechat.mybatis.pojo.Car;
import com.yr.wechat.web.common.ExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService extends ExtendService<Car> {
    @Autowired
    CarMapper carmapper;

    public void updateCar(){
         carmapper.UpdateCarNosaveSeat();
         carmapper.UpdateCarSaveSeat();
    }


    public void UpdataCarSeatByCarNum(String time8Max,String time9Max,String time10Max,String time11Max,String time14Max,String time15Max,String time16Max,String time17Max,String carSubject,String saveSeat,String CarNum){
         carmapper.UpdataCarSeatByCarNum(time8Max,time9Max,time10Max,time11Max,time14Max,time15Max,time16Max,time17Max,carSubject,saveSeat,CarNum);
    }

    public void UpdateCarInfoByCarNum(String carColor,String carType,String carNum){
        carmapper.UpdateCarInfoByCarNum(carColor,carType,carNum);
    }


    public void UpdateTime8(String CarNum){
        carmapper.UpdateTime8(CarNum);
    }

    public void UpdateTime9(String CarNum){
        carmapper.UpdateTime9(CarNum);
    }

    public void UpdateTime10(String CarNum){
        carmapper.UpdateTime10(CarNum);
    }

    public void UpdateTime11(String CarNum){
        carmapper.UpdateTime11(CarNum);
    }

    public void UpdateTime14(String CarNum){
        carmapper.UpdateTime14(CarNum);
    }

    public void UpdateTime15(String CarNum){
        carmapper.UpdateTime15(CarNum);
    }

    public void UpdateTime16(String CarNum){
        carmapper.UpdateTime16(CarNum);
    }

    public void UpdateTime17(String CarNum){
        carmapper.UpdateTime17(CarNum);
    }


    public void UpdateTime8Add(String CarNum){
        carmapper.UpdateTime8Add(CarNum);
    }

    public void UpdateTime9Add(String CarNum){
        carmapper.UpdateTime9Add(CarNum);
    }

    public void UpdateTime10Add(String CarNum){
        carmapper.UpdateTime10Add(CarNum);
    }

    public void UpdateTime11Add(String CarNum){
        carmapper.UpdateTime11Add(CarNum);
    }

    public void UpdateTime14Add(String CarNum){
        carmapper.UpdateTime14Add(CarNum);
    }

    public void UpdateTime15Add(String CarNum){
        carmapper.UpdateTime15Add(CarNum);
    }

    public void UpdateTime16Add(String CarNum){
        carmapper.UpdateTime16Add(CarNum);
    }

    public void UpdateTime17Add(String CarNum){
        carmapper.UpdateTime17Add(CarNum);
    }

    public Car getCarInfo(String CarNum){
        return carmapper.getCarInfo(CarNum);
    }

    public void SetCarSeat(String MaxSeat,String carSubject,String saveSeat,String CarNum){
        carmapper.SetCarSeat(MaxSeat,carSubject,saveSeat,CarNum);
    }
}
