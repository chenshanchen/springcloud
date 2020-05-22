package com.my.springcloudalibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenshan
 * @date 2020-05-22 17:01
 */
@Configuration
public class AppliactionContextBean {

  @Bean
  @LoadBalanced //nacos自己本身就支持负载均衡
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
