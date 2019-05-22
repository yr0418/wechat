package com.yr.wechat.mybatis.mapper;

import com.yr.wechat.mybatis.CustomMapper;
import com.yr.wechat.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface CarMapper extends CustomMapper<Car> {
    //重置车辆信息
    //重置设定不保存座位信息的车辆
    @Update("update car set time8_max=0,time8_left=0,time9_max=0,time9_left=0,time10_max=0,time10_left=0,time11_max=0,time11_left=0,time14_max=0,time14_left=0,time15_max=0,time15_left=0,time16_max=0,time16_left=0,time17_max=0,time17_left=0,car_situation='未开放',car_subject='未设置' where save_seat='no'")
    public void UpdateCarNosaveSeat();
    //重置设定保存座位信息的车辆
    @Update("update car set time8_left=time8_max,time9_left=time9_max,time10_left=time10_max,time11_left=time11_max,time14_left=time14_max,time15_left=time15_max,time16_left=time16_max,time17_left=time17_max where save_seat='yes'")
    public void UpdateCarSaveSeat();


    //各个时间段剩余座位数-1，预约操作
    @Update("update car set time8_left=time8_left-1 where car_num=#{CarNum}")
    public void UpdateTime8(String CarNum);
    @Update("update car set time9_left=time9_left-1 where car_num=#{CarNum}")
    public void UpdateTime9(String CarNum);
    @Update("update car set time10_left=time10_left-1 where car_num=#{CarNum}")
    public void UpdateTime10(String CarNum);
    @Update("update car set time11_left=time11_left-1 where car_num=#{CarNum}")
    public void UpdateTime11(String CarNum);
    @Update("update car set time14_left=time14_left-1 where car_num=#{CarNum}")
    public void UpdateTime14(String CarNum);
    @Update("update car set time15_left=time15_left-1 where car_num=#{CarNum}")
    public void UpdateTime15(String CarNum);
    @Update("update car set time16_left=time16_left-1 where car_num=#{CarNum}")
    public void UpdateTime16(String CarNum);
    @Update("update car set time17_left=time17_left-1 where car_num=#{CarNum}")
    public void UpdateTime17(String CarNum);

    //各个时间段剩余座位数+1，取消预约操作
    @Update("update car set time8_left=time8_left+1 where car_num=#{CarNum}")
    public void UpdateTime8Add(String CarNum);
    @Update("update car set time9_left=time9_left+1 where car_num=#{CarNum}")
    public void UpdateTime9Add(String CarNum);
    @Update("update car set time10_left=time10_left+1 where car_num=#{CarNum}")
    public void UpdateTime10Add(String CarNum);
    @Update("update car set time11_left=time11_left+1 where car_num=#{CarNum}")
    public void UpdateTime11Add(String CarNum);
    @Update("update car set time14_left=time14_left+1 where car_num=#{CarNum}")
    public void UpdateTime14Add(String CarNum);
    @Update("update car set time15_left=time15_left+1 where car_num=#{CarNum}")
    public void UpdateTime15Add(String CarNum);
    @Update("update car set time16_left=time16_left+1 where car_num=#{CarNum}")
    public void UpdateTime16Add(String CarNum);
    @Update("update car set time17_left=time17_left+1 where car_num=#{CarNum}")
    public void UpdateTime17Add(String CarNum);

    //自定义车辆的座位信息，放号操作
    @Update("update car set time8_max=#{time8Max},time8_left=#{time8Max},time9_max=#{time9Max},time9_left=#{time9Max},time10_max=#{time10Max},time10_left=#{time10Max},time11_max=#{time11Max},time11_left=#{time11Max},time14_max=#{time14Max},time14_left=#{time14Max},time15_max=#{time15Max},time15_left=#{time15Max},time16_max=#{time16Max},time16_left=#{time16Max},time17_max=#{time17Max},time17_left=#{time17Max},car_situation='开放',car_subject=#{carSubject},save_seat=#{saveSeat} where car_num=#{CarNum}")
    public void UpdataCarSeatByCarNum(String time8Max,String time9Max,String time10Max,String time11Max,String time14Max,String time15Max,String time16Max,String time17Max,String carSubject,String saveSeat,String CarNum);
    //设置车辆的座位信息，一键操作
    @Update("update car set time8_max=#{MaxSeat},time8_left=#{MaxSeat},time9_max=#{MaxSeat},time9_left=#{MaxSeat},time10_max=#{MaxSeat},time10_left=#{MaxSeat},time11_max=#{MaxSeat},time11_left=#{MaxSeat},time14_max=#{MaxSeat},time14_left=#{MaxSeat},time15_max=#{MaxSeat},time15_left=#{MaxSeat},time16_max=#{MaxSeat},time16_left=#{MaxSeat},time17_max=#{MaxSeat},time17_left=#{MaxSeat},car_situation='开放',car_subject=#{carSubject},save_seat=#{saveSeat} where car_num=#{CarNum}")
    public void SetCarSeat(String MaxSeat,String carSubject,String saveSeat,String CarNum);

    //根据车牌号修改车辆信息
    @Update("update car set car_color=#{carColor},car_type=#{carType} where car_num=#{carNum}")
    public void UpdateCarInfoByCarNum(String carColor,String carType,String carNum);

    //根据车牌号查询车辆信息
    @Select("select * from car where car_num=#{carNum}")
    public Car getCarInfo(String carNum);

    //增加车辆
    @Insert("insert into car(car_num,car_school_num,car_color,car_type,car_situation) values(#{CarNum},#{CarSchoolNum},#{CarColor},#{CarType},'未开放')")
    public void addCar(String CarNum,String CarSchoolNum,String CarColor,String CarType);

}