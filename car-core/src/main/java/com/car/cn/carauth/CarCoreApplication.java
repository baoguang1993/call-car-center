package com.car.cn.carauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages= {"com.libaoguang.cn.cardao.mapper"})
@EnableDiscoveryClient
public class CarCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarCoreApplication.class, args);
    }

}
