package com.qianfeng.day0818_tryshiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements Serializable {
    private int permissionId;
    private String permissionName;
    private String url;
}
