package com.yr.wechat.web.controller.SqlController;

import com.yr.wechat.mybatis.mapper.SchoolMapper;
import com.yr.wechat.mybatis.mapper.UserMapper;
import com.yr.wechat.web.service.SchoolService;
import com.yr.wechat.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@RequestMapping(value = "RecognizeUser")
public class RecognizeUser {
   @Autowired
    UserService userService;
   @Autowired
   SchoolService schoolService;

   @ApiOperation(value = "根据openid判断用户身份")
    @GetMapping()
    public String recognize(String openid){
       String id1=userService.getUserNum(openid);
       String id2=schoolService.getSchoolNum(openid);
       if(id1 != null){
           return "user";
       }
       else if(id2 != null){
           return "school";
       }
       else {
           return "null";
       }
   }
}
