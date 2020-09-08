package com.hlbrc.bicyclesales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserController {
    // 登录
    @RequestMapping(value = "login")
    @ResponseBody
    public String login(HttpServletRequest request){
        Map<String,Object> modelMap = BaseController.getParameterMap(request);
        modelMap.put("msg","ok");
        return "hasdajsdhgajsh";
    }
}
