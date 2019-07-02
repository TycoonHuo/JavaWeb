package com.huo.msb.java.hellospringboot.account.controller;

import com.github.pagehelper.PageInfo;
import com.huo.msb.java.hellospringboot.account.entity.Account;
import com.huo.msb.java.hellospringboot.account.resp.RespStat;
import com.huo.msb.java.hellospringboot.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 做页面的跳转
 *
 * @author huoyun
 * @date 2019/7/2-20:15
 */
@Controller
@RequestMapping("/account")
public class AccountPageController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/index")
    public String index() {
        return "/account/index";
    }

    @GetMapping("/login")
    public String login() {
        return "/account/login";
    }

    @GetMapping("/register")
    public String register() {
        return "/account/register";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("account");
        return "/account/index";
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        RespStat all = accountService.findAll(pageNum, pageSize);
        PageInfo pageInfo = (PageInfo) all.getData();
        model.addAttribute("accountList",pageInfo.getList());
        return "/account/list";
    }
}
