package com.qianfeng.day0818_tryshiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String userId;
    private String userName;
    private String password;
    private String phone;
    private String addr;
}
