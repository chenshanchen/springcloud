package com.my.springcloud;

import com.my.ribbon.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author chenshan
 * @date 2020-05-11 15:39
 */
@SpringBootApplication
@EnableEurekaClient
/**
 * name = "CLOUD-PAYMENT-SERVICE":代表的是提供方的暴露的 hostname
 * configuration = MySelfRule.class ： 代表的是使用 MySelfRule 中配置的负载均衡规则
 */
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
  public static void main(String[] args) {
      SpringApplication.run(OrderMain80.class,args);
    }
}
