package com.yr.wechat.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Id;
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    @Id
    private Long id;

    private String userNum;

    private String userNickname;

    private String userSchoolNum;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserSchoolNum() {
        return userSchoolNum;
    }

    public void setUserSchoolNum(String userSchoolNum) {
        this.userSchoolNum = userSchoolNum == null ? null : userSchoolNum.trim();
    }

}