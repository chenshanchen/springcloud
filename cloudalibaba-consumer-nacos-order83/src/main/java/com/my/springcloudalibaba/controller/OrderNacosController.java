package com.my.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author chenshan
 * @date 2020-05-22 17:00
 */

@RestController
public class OrderNacosController {

  /**
   * 在 application.properties 文件中配置了
   *    service-url.nacos-user-service=http://nacos-payment-provider
   *  nacos-payment-provider：是 提供者在 nacos 中的标识
   */
  @Value("${service-url.nacos-user-service}")
  private String serverURL;

  @Resource
  private RestTemplate restTemplate;

  @GetMapping(value = "/consumer/payment/nacos/{id}")
  public String paymentInfo(@PathVariable("id") Long id)
  {
    System.out.println("********"+serverURL);
    return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
  }


}
