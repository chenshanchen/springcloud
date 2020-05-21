package com.my.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenshan
 * @date 2020-05-11 15:41
 */
@Configuration
public class ApplicationContextConfig {

  @Bean
//  @LoadBalanced
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }
}
