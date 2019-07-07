package com.huo.msb.java.hellospringboot.account.mapper;

import com.huo.msb.java.hellospringboot.account.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * AccountDAO继承基类
 */
@Repository
public interface AccountDAO extends MyBatisBaseDao<Account, Integer, AccountExample> {
}