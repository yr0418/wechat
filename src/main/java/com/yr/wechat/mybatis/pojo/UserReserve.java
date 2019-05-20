package com.yr.wechat.mybatis.pojo;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class UserReserve {
    private String userNickname;

    private String carNum;

    private String carType;

    private String carColor;

    private String carSubject;

    private String userSituation;

    private Integer time;
}
