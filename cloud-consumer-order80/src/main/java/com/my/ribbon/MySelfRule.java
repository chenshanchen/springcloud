package com.my.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenshan
 * @date 2020-05-12 17:11
 */
@Configuration
public class MySelfRule {

  @Bean
  public IRule myRule(){
    //使用 随机 的规则
    return new RandomRule();
  }
}
