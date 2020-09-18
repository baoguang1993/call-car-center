package com.libaoguang.cn.carcustomer;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan(basePackages= {"com.libaoguang.cn.cardao.mapper"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.libaoguang.cn.carorderdef.def.order"})
public class CarCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarCustomerApplication.class, args);
    }

}
