package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenshan
 * @date 2020-06-02 16:25
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderOpenFeignMain84 {
  public static void main(String[] args) {
      SpringApplication.run(OrderOpenFeignMain84.class,args);
    }
}
