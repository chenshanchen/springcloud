package com.springcloud.controller;

import com.springcloud.service.HystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenshan
 * @date 2020-05-14 10:47
 */
@RestController
public class HystrixController {

  @Resource
  private HystrixService hystrixService;

  @GetMapping("/payment/hystrix/ok/{id}")
  public String paymentInfo_OK(@PathVariable("id") Integer id) {
    String result = hystrixService.paymentInfo_OK(id);
    System.out.println("*************result" + result);
    return result;
  }

  @GetMapping("/payment/hystrix/timeout/{id}")
  public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
    String result = hystrixService.paymentInfo_TimeOut(id);
    System.out.println("*************result" + result);
    return result;
  }

  @GetMapping("/payment/hystrix/circuit/{id}")
  public String paymentCircuitBreaker(@PathVariable("id") Integer id){
    String result = hystrixService.paymentCircuitBreaker(id);
    System.out.println("*****result" + result);
    return result;
  }
}
