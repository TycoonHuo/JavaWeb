package com.huo.msb.java.hellospringboot.account.mapper;

import com.huo.msb.java.hellospringboot.account.entity.Account;

import java.util.List;

/**
 * @author huoyun
 * @date 2019/6/30-19:17
 */
public interface AccountMapper {
    Integer save(Account account);

    List<Account> findAll();

    Integer deleteById(Integer id);

    Account findById(Integer id);

    Integer updateById(Account account);

    Account findByLoginNameAndPassword(Account account);
}
