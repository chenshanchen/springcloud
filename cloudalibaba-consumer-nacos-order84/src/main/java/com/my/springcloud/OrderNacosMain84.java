package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenshan
 * @date 2020-06-02 14:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain84 {
  public static void main(String[] args) {
      SpringApplication.run(OrderNacosMain84.class,args);
    }
}
