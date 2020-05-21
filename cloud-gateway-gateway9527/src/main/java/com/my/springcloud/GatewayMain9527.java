package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenshan
 * @date 2020-05-15 11:13
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
  public static void main(String[] args) {
      SpringApplication.run(GatewayMain9527.class,args);
    }
}
