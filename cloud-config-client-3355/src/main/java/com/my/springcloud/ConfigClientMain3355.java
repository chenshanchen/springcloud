package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenshan
 * @date 2020-05-20 13:31
 */

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {

  public static void main(String[] args) {
      SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
