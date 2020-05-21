package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author chenshan
 * @date 2020-05-20 10:46
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
  public static void main(String[] args) {
      SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
