package com.jianer.springbootjwt.controller;

import com.jianer.springbootjwt.annotation.TokenValidate;
import com.jianer.springbootjwt.component.JwtUtil;
import com.jianer.springbootjwt.entity.UserInfo;
import com.jianer.springbootjwt.vo.ResultCode;
import com.jianer.springbootjwt.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 杨兴健
 * @Date 2020/4/27 9:45
 */
@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    @TokenValidate(validate = false)
    public ResultVo login(@Validated UserInfo user, HttpServletRequest request, HttpServletResponse response) {

        if ("jianer".equals(user.getName()) && "jianer".equals(user.getPassword())) {
            try {
                String token = jwtUtil.createToken(user.getName());
                log.info("token:{}",token);
                response.setHeader("token","token_".concat(token));
                return new ResultVo(ResultCode.SUCCESS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResultVo(ResultCode.VALIDATE_ERROR);
    }
}
