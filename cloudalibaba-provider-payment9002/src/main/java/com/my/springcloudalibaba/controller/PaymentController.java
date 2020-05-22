package com.my.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenshan
 * @date 2020-05-22 16:49
 */
@RestController
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  @GetMapping(value = "/payment/nacos/{id}")
  public String getPayment(@PathVariable("id") Integer id)
  {
    return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
  }
}
