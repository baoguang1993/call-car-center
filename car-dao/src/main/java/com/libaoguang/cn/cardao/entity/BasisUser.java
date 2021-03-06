package com.libaoguang.cn.cardao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;


import java.io.Serializable;
import java.util.Date;

@TableName(value = "basis_user")
@Data
@ToString
public class BasisUser implements Serializable {

    //指定自增策略
    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    @TableField(value = "user_address")
    private String userAddress;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "password")
    private String password;

    @TableField(value = "status")
    private int status;

    @TableField(value = "user_age")
    private int age;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_time")
    private Date updateTime;


}
