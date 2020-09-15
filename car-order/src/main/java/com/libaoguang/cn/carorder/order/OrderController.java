package com.libaoguang.cn.carorder.order;

import com.libaoguang.cn.carcommon.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @RequestMapping("/api/order/createOrder")
    ResultVo createOrder(String requestBody){
        System.out.println("requestBody:"+requestBody);
        return ResultVo.successResult();
    }
}
