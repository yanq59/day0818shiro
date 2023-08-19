package com.qianfeng.day0818_tryshiro.dao;

import com.qianfeng.day0818_tryshiro.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    List<Role> findRoleByUserId(String userId);
}
