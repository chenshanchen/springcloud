package com.my.springcloud.controller;

import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import com.my.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenshan
 * @date 2020-05-13 17:34
 */
@RestController
public class PaymentFeignController {

  @Resource
  private PaymentFeignService paymentFeignService;

  @GetMapping("/consumer/payment/get/{id}")
  public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
    return paymentFeignService.getPaymentById(id);
  }


}
