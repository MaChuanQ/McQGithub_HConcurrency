package com.example.seckill.controller;

import com.example.seckill.service.impl.UserServiceImpl;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserServiceImpl userService;

    //登陆页面挑战
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    //登录功能实现
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        log.info("{}"+loginVo);
        RespBean respBean = userService.doLogin(loginVo, request, response);
        return respBean;
    }
}
