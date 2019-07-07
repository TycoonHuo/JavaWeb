package com.huo.msb.java.hellospringboot.account.mapper;

import com.huo.msb.java.hellospringboot.account.entity.Permission;
import org.springframework.stereotype.Repository;

/**
 * PermissionDAO继承基类
 */
@Repository
public interface PermissionDAO extends MyBatisBaseDao<Permission, Integer, PermissionExample> {
}