package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author chenshan
 * @date 2020-05-12 10:01
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
  public static void main(String[] args) {
      SpringApplication.run(EurekaMain7002.class,args);
    }
}
