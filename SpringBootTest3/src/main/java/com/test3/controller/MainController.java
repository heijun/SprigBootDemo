package com.test3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/login")
    @ResponseBody()
    public String login(){
        return "欢迎回来";
    }
}
