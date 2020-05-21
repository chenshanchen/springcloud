package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenshan
 * @date 2020-05-20 16:47
 */

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366 {
  public static void main(String[] args) {
      SpringApplication.run(ConfigClientMain3366.class,args);
    }
}
