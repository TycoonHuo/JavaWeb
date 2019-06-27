package com.huo.msb.java.hellospringboot.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 跟用户相关的controller
 *
 * @author huoyun
 * @date 2019/6/27-23:09
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    /**
     * 负责跳转登录页
     *
     * @return template login.html
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * post 请求 登录
     */
    @PostMapping("login")
    @ResponseBody
    public String loginMethod(@RequestParam("email") String email, @RequestParam("password") String password) {
        System.out.println("email:" + email);
        System.out.println("password:" + password);
        if ("huo@yo.com".equals(email)) {
            return "ok";
        } else {
            return "fail";
        }
    }

    /**
     * index 页面 跳转
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
