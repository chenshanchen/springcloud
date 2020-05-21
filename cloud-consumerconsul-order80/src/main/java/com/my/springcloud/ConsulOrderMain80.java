package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenshan
 * @date 2020-05-12 16:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderMain80 {
  public static void main(String[] args) {
      SpringApplication.run(ConsulOrderMain80.class,args);
    }
}
