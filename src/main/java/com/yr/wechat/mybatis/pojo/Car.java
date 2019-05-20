package com.yr.wechat.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Id;
public class Car {
    @Id
    private Long id;

    private String carNum;

    private String carSchoolNum;

    private String carColor;

    private String carType;

    private String carSituation;

    private String saveSeat;

    private String carSubject;

    private Integer time8Max;

    private Integer time8Left;

    private Integer time9Max;

    private Integer time9Left;

    private Integer time10Max;

    private Integer time10Left;

    private Integer time11Max;

    private Integer time11Left;

    private Integer time14Max;

    private Integer time14Left;

    private Integer time15Max;

    private Integer time15Left;

    private Integer time16Max;

    private Integer time16Left;

    private Integer time17Max;

    private Integer time17Left;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum == null ? null : carNum.trim();
    }

    public String getCarSchoolNum() {
        return carSchoolNum;
    }

    public void setCarSchoolNum(String carSchoolNum) {
        this.carSchoolNum = carSchoolNum == null ? null : carSchoolNum.trim();
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor == null ? null : carColor.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public String getCarSituation() {
        return carSituation;
    }

    public void setCarSituation(String carSituation) {
        this.carSituation = carSituation;
    }

    public Integer getTime8Max() {
        return time8Max;
    }

    public void setTime8Max(Integer time8Max) {
        this.time8Max = time8Max;
    }

    public Integer getTime8Left() {
        return time8Left;
    }

    public void setTime8Left(Integer time8Left) {
        this.time8Left = time8Left;
    }

    public Integer getTime9Max() {
        return time9Max;
    }

    public void setTime9Max(Integer time9Max) {
        this.time9Max = time9Max;
    }

    public Integer getTime9Left() {
        return time9Left;
    }

    public void setTime9Left(Integer time9Left) {
        this.time9Left = time9Left;
    }

    public Integer getTime10Max() {
        return time10Max;
    }

    public void setTime10Max(Integer time10Max) {
        this.time10Max = time10Max;
    }

    public Integer getTime10Left() {
        return time10Left;
    }

    public void setTime10Left(Integer time10Left) {
        this.time10Left = time10Left;
    }

    public Integer getTime11Max() {
        return time11Max;
    }

    public void setTime11Max(Integer time11Max) {
        this.time11Max = time11Max;
    }

    public Integer getTime11Left() {
        return time11Left;
    }

    public void setTime11Left(Integer time11Left) {
        this.time11Left = time11Left;
    }

    public Integer getTime14Max() {
        return time14Max;
    }

    public void setTime14Max(Integer time14Max) {
        this.time14Max = time14Max;
    }

    public Integer getTime14Left() {
        return time14Left;
    }

    public void setTime14Left(Integer time14Left) {
        this.time14Left = time14Left;
    }

    public Integer getTime15Max() {
        return time15Max;
    }

    public void setTime15Max(Integer time15Max) {
        this.time15Max = time15Max;
    }

    public Integer getTime15Left() {
        return time15Left;
    }

    public void setTime15Left(Integer time15Left) {
        this.time15Left = time15Left;
    }

    public Integer getTime16Max() {
        return time16Max;
    }

    public void setTime16Max(Integer time16Max) {
        this.time16Max = time16Max;
    }

    public Integer getTime16Left() {
        return time16Left;
    }

    public void setTime16Left(Integer time16Left) {
        this.time16Left = time16Left;
    }

    public Integer getTime17Max() {
        return time17Max;
    }

    public void setTime17Max(Integer time17Max) {
        this.time17Max = time17Max;
    }

    public Integer getTime17Left() {
        return time17Left;
    }

    public void setTime17Left(Integer time17Left) {
        this.time17Left = time17Left;
    }


    public String getSaveSeat() {
        return saveSeat;
    }

    public void setSaveSeat(String saveSeat) {
        this.saveSeat = saveSeat;
    }

    public String getCarSubject() {
        return carSubject;
    }

    public void setCarSubject(String carSubject) {
        this.carSubject = carSubject;
    }
}