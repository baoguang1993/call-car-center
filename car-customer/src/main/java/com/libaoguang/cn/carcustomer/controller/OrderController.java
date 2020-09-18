package com.libaoguang.cn.carcustomer.controller;


import com.libaoguang.cn.carcommon.vo.ResultVo;
import com.libaoguang.cn.carorderdef.def.order.OrderFeignClients;
import com.libaoguang.cn.carorderdef.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderFeignClients orderFeignClients;

    @RequestMapping("/api/customer/createOrder")
    ResultVo createOrder(String userGuid){

        List<OrderDTO> orderDTOList = orderFeignClients.createOrder(userGuid);
        ResultVo resultVo = ResultVo.successResult(orderDTOList);
        resultVo.setTotalPage(10);
        return resultVo;
    }
}
