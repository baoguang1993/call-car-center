package com.libaoguang.cn.carorder.controller.order;

import com.libaoguang.cn.carorderdef.def.order.OrderFeignClients;
import com.libaoguang.cn.carorderdef.dto.OrderDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class OrderController implements OrderFeignClients {


    @RequestMapping("/api/order/createOrder")
    @Override
    public List<OrderDTO> createOrder(String userGuid) {
        System.out.println("requestBody:"+userGuid);
        List<OrderDTO> orderDTOList=new ArrayList<>();
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setCreateTime(new Date());
        orderDTO.setOrderGuid(UUID.randomUUID().toString().replace("-",""));
        orderDTOList.add(orderDTO);

        return orderDTOList;
    }
}
