package com.qianfeng.day0818_tryshiro.dao;

import com.qianfeng.day0818_tryshiro.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
    List<Permission> findPremissionByRoleId(int roleId);
}
