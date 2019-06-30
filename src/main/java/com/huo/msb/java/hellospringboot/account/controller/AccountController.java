package com.huo.msb.java.hellospringboot.account.controller;

import com.huo.msb.java.hellospringboot.account.entity.Account;
import com.huo.msb.java.hellospringboot.account.resp.RespStat;
import com.huo.msb.java.hellospringboot.account.service.AccountService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 跟用户相关的controller
 *
 * @author huoyun
 * @date 2019/6/27-23:09
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountSrv;


    @PostMapping("/regist")
    public RespStat regist(@RequestBody Account account) {

        return accountSrv.save(account);
    }

    @GetMapping("/list")
    public RespStat list() {
        return accountSrv.findAll();
    }

    @GetMapping("/{id}")
    public RespStat getById(@PathVariable("id") Integer id) {
        return accountSrv.findById(id);
    }

    @DeleteMapping("/{id}")
    public RespStat deleteById(@PathVariable("id") Integer id) {
        return accountSrv.deleteById(id);
    }

    @PatchMapping
    public RespStat editById(@RequestBody Account account){
        return accountSrv.editById(account);
    }

    @PostMapping("/login")
    public RespStat login(@RequestBody Account account){
        return accountSrv.login(account);
    }
}
