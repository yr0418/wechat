package com.yr.wechat.mybatis.mapper;

import com.yr.wechat.mybatis.CustomMapper;
import com.yr.wechat.mybatis.pojo.Reserve;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReserveMapper extends CustomMapper<Reserve> {
    //判断用户预约状态
    @Select("select user_num from reserve where user_num=#{userNum}")
    public String getUseropenid(String userNum);

    //根据openid取消预约信息
    @Delete("delete from reserve where user_num=#{userNum}")
    public void deletereserve(String userNum);

    //根据openid获取预约信息
    @Select("select * from reserve where user_num=#{userNum}")
    public Reserve getReserveByUserNum(String userNum);

    //根据预定的时间获取预约信息
    @Select("select * from reserve where time=#{time}")
    public List<Reserve>  getInfobyTime(int time);

    //用户改签操作
    @Update("update reserve set time=#{time} where user_num=#{userNum}")
    public void UpdateTime(String userNum,int time);

    //修改用户状态为 “正在练车”
    @Update("update reserve set situation='正在练车' where user_num=#{userNum}")
    void UpdateSituation(String userNum);

    @Update("update reserve set situation='练车完成' where user_num=#{userNum}")
    void UpdateSituationToFinsh(String userNum);

    //驾校查看车辆的预订信息
    @Select("select * from reserve where car_num=#{carNum}")
    public List<Reserve> carReserveInfo(String carNum);

}