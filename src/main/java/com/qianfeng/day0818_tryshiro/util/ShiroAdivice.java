package com.qianfeng.day0818_tryshiro.util;


import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShiroAdivice {
    @ExceptionHandler
    public String doException(AuthorizationException ex){
        System.out.println("没有访问权限");
        return "redirect:/authc.jsp";
    }
}
