package com.libaoguang.cn.carorderdef.def.order;

import com.libaoguang.cn.carorderdef.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "car-order")
public interface OrderFeignClients {

    @RequestMapping("/car-order/api/order/createOrder")
    List<OrderDTO> createOrder(@RequestParam String userGuid);
}
