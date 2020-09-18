package com.libaoguang.cn.carorderdef.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderDTO implements Serializable {
    private String orderGuid;
    private Date createTime;


}
