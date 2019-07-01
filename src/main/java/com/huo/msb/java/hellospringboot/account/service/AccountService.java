package com.huo.msb.java.hellospringboot.account.service;

import com.github.pagehelper.PageHelper;
import com.huo.msb.java.hellospringboot.account.entity.Account;
import com.huo.msb.java.hellospringboot.account.entity.AccountExample;
import com.huo.msb.java.hellospringboot.account.mapper.AccountDAO;
import com.huo.msb.java.hellospringboot.account.resp.RespStat;
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
    private AccountDAO accountDAO;

    public RespStat save(Account account) {
        Integer result = null;
        try {
            result = accountDAO.insert(account);
        } catch (Exception e) {
            e.printStackTrace();
            return RespStat.build(500, e.getMessage(), null);
        }
        return RespStat.build(200, "ok", result);

    }


    public RespStat findAll(Integer page, Integer size) {
        AccountExample accountExample = new AccountExample();
        List<Account> all = null;
        if (page == null && size == null) {
            // 默认就是查所有
//        accountExample.createCriteria().;
            all = accountDAO.selectByExample(accountExample);
            return RespStat.build(200, "success", all);
        }

        // 分页查询
        PageHelper.startPage(page, size);
        all = accountDAO.selectByExample(accountExample);
        return RespStat.build(200, "success", all);

    }

    public RespStat deleteById(Integer id) {
        Integer result = null;
        try {
            result = accountDAO.deleteByPrimaryKey(id);
        } catch (Exception e) {
            return RespStat.build(500, e.getMessage(), null);
        }
        return RespStat.build(200, "ok", result);
    }

    public RespStat findById(Integer id) {
        Account result = null;
        try {
            result = accountDAO.selectByPrimaryKey(id);
        } catch (Exception e) {
            return RespStat.build(500, e.getMessage(), result);

        }
        return RespStat.build(200, "ok", result);

    }

    //
//    public RespStat editById(Account account) {
//        Integer result = null;
//        try {
//            result = mapper.updateById(account);
//        } catch (Exception e) {
//            return RespStat.build(500, e.getMessage(), result);
//        }
//        return RespStat.build(200, "ok", result);
//    }
//
    public RespStat login(Account account) {
        Account result = null;
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andLoginNameEqualTo(account.getLoginName()).andPasswordEqualTo(account.getPassword());
        try {
            List<Account> accounts = accountDAO.selectByExample(accountExample);
            if (accounts.size() == 1) {
                result = accounts.get(0);
            } else {
                return RespStat.build(401, "用户名密码错误", result);
            }
        } catch (Exception e) {
            return RespStat.build(500, e.getMessage(), result);

        }
        return RespStat.build(200, "ok", result);

    }
}
