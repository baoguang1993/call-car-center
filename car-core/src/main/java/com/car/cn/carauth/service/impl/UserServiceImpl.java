package com.car.cn.carauth.service.impl;


import com.car.cn.carauth.manager.UserManager;
import com.car.cn.carauth.service.Interface.UserService;
import com.libaoguang.cn.cardao.entity.BasisUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;
    @Override
   public List<BasisUser> listUser(){
        List<BasisUser> basisUsers = userManager.listUser();
        return basisUsers;
    }
}
