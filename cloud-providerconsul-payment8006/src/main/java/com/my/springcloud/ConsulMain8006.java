package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenshan
 * @date 2020-05-12 15:56
 */
@SpringBootApplication
/**
 * 该注解用于使用 consul/zookeeper 作为注册中心时注册任务
 */
@EnableDiscoveryClient
public class ConsulMain8006 {
  
  public static void main(String[] args) {
      SpringApplication.run(ConsulMain8006.class,args);
    }
}
