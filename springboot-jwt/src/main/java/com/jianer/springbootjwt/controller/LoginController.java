package com.jianer.springbootjwt.controller;

import com.jianer.springbootjwt.annotation.TokenValidate;
import com.jianer.springbootjwt.component.JwtUtil;
import com.jianer.springbootjwt.vo.ResultCode;
import com.jianer.springbootjwt.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    @TokenValidate(validate = false)
    public ResultVo login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return new ResultVo(ResultCode.LOGIN_FAILED_1);
        }
        if ("jianer".equals(username) && "jianer".equals(password)) {
            try {
                String token = jwtUtil.createToken(username);
                response.setHeader("token","token_".concat(token));
                return new ResultVo(ResultCode.SUCCESS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResultVo(ResultCode.LOGIN_FAILED_2);
    }
}
