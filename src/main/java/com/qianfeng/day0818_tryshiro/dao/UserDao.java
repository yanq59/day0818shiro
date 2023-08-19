package com.qianfeng.day0818_tryshiro.dao;

import com.qianfeng.day0818_tryshiro.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User login(String userId);
}
