package com.car.cn.carauth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.car.cn.carauth.service.CarUserDetailsService;
import com.libaoguang.cn.cardao.entity.BasisUser;
import com.libaoguang.cn.cardao.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class CarUserDetailsServiceImpl implements CarUserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public BasisUser getByName(String userName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", userName);
        return userDao.selectOne(queryWrapper);

    }
}
