package com.my.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenshan
 * @date 2020-05-22 16:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {
  public static void main(String[] args) {
      SpringApplication.run(PaymentMain9002.class,args);
    }
}
