package com.libaoguang.cn.carcustomer.controller;


import com.libaoguang.cn.carcommon.vo.ResultVo;
import com.libaoguang.cn.carorderdef.order.OrderFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderFeignClients orderFeignClients;

    @RequestMapping("/api/customer/createOrder")
    ResultVo createOrder(String requestBody){

        ResultVo order = orderFeignClients.createOrder(requestBody);
        System.out.println("order"+order);
        System.out.println("requestBody:"+requestBody);
        return ResultVo.successResult();
    }
}
