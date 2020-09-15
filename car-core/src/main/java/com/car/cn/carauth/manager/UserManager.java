package com.car.cn.carauth.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.libaoguang.cn.cardao.entity.BasisUser;
import com.libaoguang.cn.cardao.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManager {
    @Autowired
    private UserDao userDao;

    public List<BasisUser> listUser(){
        QueryWrapper queryWrapper=new QueryWrapper();
        List list = userDao.selectList(queryWrapper);
        return list;
    }
}
