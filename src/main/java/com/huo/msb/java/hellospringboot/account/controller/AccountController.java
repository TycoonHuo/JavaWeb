package com.huo.msb.java.hellospringboot.account.controller;

import com.huo.msb.java.hellospringboot.account.entity.Account;
import com.huo.msb.java.hellospringboot.account.resp.RespStat;
import com.huo.msb.java.hellospringboot.account.service.AccountService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 跟用户相关的controller
 *
 * @author huoyun
 * @date 2019/6/27-23:09
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountSrv;


    @PostMapping("/register")
    public RespStat register(Account account) {
        return accountSrv.save(account);
    }

    @GetMapping("/list")
    public RespStat list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return accountSrv.findAll(page, size);
    }

    @GetMapping("/{id}")
    public RespStat getById(@PathVariable("id") Integer id) {
        return accountSrv.findById(id);
    }

//    @DeleteMapping("/{id}")
//    public RespStat deleteById(@PathVariable("id") Integer id) {
//        return accountSrv.deleteById(id);
//    }

    @PostMapping("/login")
    public RespStat login(Account account, HttpServletRequest request) {
        return accountSrv.login(account,request);
    }

    @PostMapping("/deleteById")
    public RespStat deleteById(Integer id){
        return accountSrv.deleteById(id);
    }
}
