package com.qianfeng.day0818_tryshiro.dao;

import com.qianfeng.day0818_tryshiro.Day0818TryshiroApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Day0818TryshiroApplication.class)
public class RoleDaoTest {
    @Autowired
    RoleDao roleDao;

    @Test
    public void findRoleByUserId() {
        System.out.println(roleDao.findRoleByUserId("wz"));
    }
}