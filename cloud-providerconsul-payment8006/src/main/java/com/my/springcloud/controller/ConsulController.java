package com.my.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author chenshan
 * @date 2020-05-12 15:59
 */
@RestController
@Slf4j
public class ConsulController {

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("/payment/consul")
  public Object paymentConsul(){
    return "springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
  }
}
