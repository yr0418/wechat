package com.yr.wechat.mybatis.pojo;

public class CarSeat {
    private String carNum;

    private String carSchoolNum;

    private String carColor;

    private String carType;


    private Integer Maxseat;

    private Integer Leftseat;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarSchoolNum() {
        return carSchoolNum;
    }

    public void setCarSchoolNum(String carSchoolNum) {
        this.carSchoolNum = carSchoolNum;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }


    public Integer getMaxseat() {
        return Maxseat;
    }

    public void setMaxseat(Integer maxseat) {
        Maxseat = maxseat;
    }

    public Integer getLeftseat() {
        return Leftseat;
    }

    public void setLeftseat(Integer leftseat) {
        Leftseat = leftseat;
    }
}
