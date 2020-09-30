package com.car.cn.carauth.service;


import com.libaoguang.cn.cardao.entity.BasisUser;

public interface CarUserDetailsService  {
    BasisUser getByName(String userName);
}
