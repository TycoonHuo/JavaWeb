package com.huo.msb.java.hellospringboot.account.service;

import com.huo.msb.java.hellospringboot.account.entity.Account;
import com.huo.msb.java.hellospringboot.account.mapper.AccountMapper;
import com.huo.msb.java.hellospringboot.account.resp.RespStat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author huoyun
 * @date 2019/6/29-12:40
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper mapper;

    public RespStat save(Account account) {
        Integer result = null;
        try {
            result = mapper.save(account);
        } catch (Exception e) {
            e.printStackTrace();
            return RespStat.build(500, e.getMessage(), null);
        }
        return RespStat.build(200, "ok", result);

    }


    public RespStat findAll() {
        List<Account> all = mapper.findAll();
        return RespStat.build(200, "success", all);
    }

    public RespStat deleteById(Integer id) {
       Integer result = null;
        try {
            result = mapper.deleteById(id);
        } catch (Exception e) {
            return RespStat.build(500, e.getMessage(), null);
        }
        return RespStat.build(200, "ok", result);
    }

    public RespStat findById(Integer id) {
        Account result = null;
        try {
           result =  mapper.findById(id);
        }catch (Exception e){
            return RespStat.build(500, e.getMessage(), result);

        }
        return RespStat.build(200, "ok", result);

    }

    public RespStat editById(Account account) {
        Integer result = null;
        try {
            result = mapper.updateById(account);
        }catch (Exception e){
            return RespStat.build(500, e.getMessage(), result);
        }
        return RespStat.build(200,"ok",result);
    }
}
