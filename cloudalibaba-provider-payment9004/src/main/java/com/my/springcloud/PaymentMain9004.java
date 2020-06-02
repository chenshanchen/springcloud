package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenshan
 * @date 2020-06-02 14:07
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9004 {
  public static void main(String[] args) {
      SpringApplication.run(PaymentMain9004.class,args);
    }
}
