package com.huo.msb.java.hellospringboot.account.mapper;

import com.huo.msb.java.hellospringboot.account.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * RoleDAO继承基类
 */
@Repository
public interface RoleDAO extends MyBatisBaseDao<Role, Integer, RoleExample> {
}