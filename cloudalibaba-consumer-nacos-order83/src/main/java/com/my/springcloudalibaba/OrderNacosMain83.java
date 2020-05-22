package com.my.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenshan
 * @date 2020-05-22 17:00
 */

@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain83 {
  
  public static void main(String[] args) {
      SpringApplication.run(OrderNacosMain83.class,args);
    }
}
