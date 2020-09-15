package com.libaoguang.cn.carorderdef.order;

import com.libaoguang.cn.carcommon.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "car-order")
public interface OrderFeignClients {

    @RequestMapping("/api/order/createOrder")
    ResultVo createOrder(String requestBody);
}
