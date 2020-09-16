package com.libaoguang.cn.carorder.order;

import com.libaoguang.cn.carcommon.vo.ResultVo;
import com.libaoguang.cn.carorderdef.order.OrderFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderFeignClients {


    @RequestMapping("/api/order/createOrder")
    @Override
    public ResultVo createOrder(String requestBody) {
        System.out.println("requestBody:"+requestBody);
        return ResultVo.successResult();
    }
}
