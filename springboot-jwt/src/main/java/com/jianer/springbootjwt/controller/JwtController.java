package com.jianer.springbootjwt.controller;

import com.jianer.springbootjwt.annotation.TokenValidate;
import com.jianer.springbootjwt.component.JwtUtil;
import com.jianer.springbootjwt.entity.UserInfo;
import com.jianer.springbootjwt.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨兴健
 * @Date 2020/4/26 22:05
 */
@RestController
@RequestMapping("/jwt")
public class JwtController {

    @GetMapping("/hello")
    @TokenValidate
    public ResultVo hello() {
        UserInfo user = new UserInfo();
        user.setName("杨兴健").setAge(30).setGender(true);
        return new ResultVo(user);
    }
}