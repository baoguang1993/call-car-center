package com.car.cn.carauth.controller;



import com.car.cn.carauth.service.Interface.UserService;
import com.libaoguang.cn.carcommon.vo.ResultVo;
import com.libaoguang.cn.cardao.entity.BasisUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ResultVo test() {
        List<BasisUser> basisUsers = userService.listUser();
        System.out.println(basisUsers);
        ResultVo resultVo=ResultVo.successResult();
        return resultVo;
    }
}
