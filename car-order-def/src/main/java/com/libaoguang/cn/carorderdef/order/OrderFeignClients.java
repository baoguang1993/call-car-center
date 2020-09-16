package com.libaoguang.cn.carorderdef.order;


import com.libaoguang.cn.carcommon.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "car-order")
public interface OrderFeignClients {

    @RequestMapping("/car-order/api/order/createOrder")
    ResultVo createOrder(@RequestParam String requestBody);
}
