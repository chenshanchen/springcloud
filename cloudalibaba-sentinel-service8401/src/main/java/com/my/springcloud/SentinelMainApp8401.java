package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenshan
 * @date 2020-05-26 14:37
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMainApp8401 {
  public static void main(String[] args) {
      SpringApplication.run(SentinelMainApp8401.class,args);
    }
}
