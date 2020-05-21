package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenshan
 * @date 2020-05-21 17:25
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8801 {

  public static void main(String[] args) {
      SpringApplication.run(StreamMQMain8801.class,args);
    }
}
