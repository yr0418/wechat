package com.yr.wechat.web.controller;

import com.yr.wechat.mybatis.pojo.Car;
import com.yr.wechat.mybatis.pojo.Reserve;
import com.yr.wechat.mybatis.pojo.School;
import com.yr.wechat.mybatis.pojo.UserReserve;
import com.yr.wechat.web.common.ExtendController;
import com.yr.wechat.web.service.CarService;
import com.yr.wechat.web.service.ReserveService;
import com.yr.wechat.web.service.SchoolService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "School")
public class SchoolController extends ExtendController<School> {
    @Autowired
    SchoolService schoolService;

    @Autowired
    ReserveService reserveService;

    @Autowired
    CarService carService;

    @ApiOperation(value ="根据驾校的openid查询相关的车辆信息")
    @GetMapping(value = "/getCarbySchoolNum")
    public List<Car> getCarbySchoolNum(String schoolNum){
        return schoolService.getCarbySchoolNum(schoolNum);
    }

    @ApiOperation(value = "根据驾校openid查询驾校的相关信息")
    @GetMapping("/selectSchool")
    public List<School> selectSchool(String SchoolNum){
        return schoolService.selectSchool(SchoolNum);
    }

    //根据车牌号查询该车的预订信息
    @ApiOperation(value = "根据车牌号查询该车的预订信息")
    @GetMapping(value = "/carReserveInfo")
    public List<UserReserve> carReserveInfo(String carNum){
        List<Reserve> reserveList=reserveService.carReserveInfo(carNum);
        Car carInfo=carService.getCarInfo(carNum);
        List<UserReserve> list=new ArrayList<>();
        for (int i = 0; i <reserveList.size() ; i++) {
            UserReserve userReserve=new UserReserve();
            userReserve.setUserNickname(reserveList.get(i).getUserNickname());
            userReserve.setUserSituation(reserveList.get(i).getSituation());
            userReserve.setTime(reserveList.get(i).getTime());
            userReserve.setCarType(carInfo.getCarType());
            userReserve.setCarSubject(carInfo.getCarSubject());
            userReserve.setCarColor(carInfo.getCarColor());
            userReserve.setCarNum(carNum);
            list.add(userReserve);
        }
        return list;
    }

    @ApiOperation(value = "注册驾校")
    @PostMapping(value = "/addSchool")
    public String AddSchool(String SchoolNum,String SchoolName,String SchoolLocation){
        String school=schoolService.getSchoolNum(SchoolNum);
        if (school==null){
            schoolService.AddSchool(SchoolNum,SchoolName,SchoolLocation);
            return "ok";
        }else {
            return "no";
        }
    }
}
