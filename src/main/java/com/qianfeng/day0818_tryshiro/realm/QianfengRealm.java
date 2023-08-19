package com.qianfeng.day0818_tryshiro.realm;

import com.qianfeng.day0818_tryshiro.dao.PermissionDao;
import com.qianfeng.day0818_tryshiro.dao.RoleDao;
import com.qianfeng.day0818_tryshiro.dao.UserDao;
import com.qianfeng.day0818_tryshiro.pojo.Permission;
import com.qianfeng.day0818_tryshiro.pojo.Role;
import com.qianfeng.day0818_tryshiro.pojo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QianfengRealm extends AuthorizingRealm {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    PermissionDao permissionDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        String userId = principalCollection.getPrimaryPrincipal().toString();
        List<Role> roles = roleDao.findRoleByUserId(userId);
        for (Role role:
             roles) {
            simpleAuthorizationInfo.addRole(role.getRoleName());
            List<Permission> permissions = permissionDao.findPremissionByRoleId(role.getRoleId());
            for (Permission permission:
                 permissions) {
                simpleAuthorizationInfo.addStringPermission(permission.getUrl());
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Object objUserId = authenticationToken.getPrincipal();
        if (objUserId == null){
            return null;
        }
        String userId = objUserId.toString();
        User user = userDao.login(userId);

        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        if (user == null){
            return null;
        }else {
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(userId,user.getPassword(),getName());
            return simpleAuthenticationInfo;
        }

    }
}
