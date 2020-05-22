package com.my.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenshan
 * @date 2020-05-22 16:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9001 {
  
  public static void main(String[] args) {
      SpringApplication.run(PaymentMain9001.class,args);
    }
}
