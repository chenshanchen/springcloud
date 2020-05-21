package com.my.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author chenshan
 * @date 2020-05-12 16:05
 */
@RestController
public class ConsulOrderController {

  public static final String INVOME_URL = "http://consul-provider-payment";

  @Resource
  private RestTemplate restTemplate;

  @GetMapping("/consumer/payment/consul")
  public String OrderPayment(){
    return restTemplate.getForObject(INVOME_URL + "/payment/consul" , String.class);
  }

}
