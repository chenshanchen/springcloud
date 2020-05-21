package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenshan
 * @date 2020-05-13 17:33
 */

@SpringBootApplication
@EnableFeignClients
public class FeignOrderMain80 {
  public static void main(String[] args) {
      SpringApplication.run(FeignOrderMain80.class,args);
    }
}
