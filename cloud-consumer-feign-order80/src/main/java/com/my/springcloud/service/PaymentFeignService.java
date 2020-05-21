package com.my.springcloud.service;

import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author chenshan
 * @date 2020-05-13 17:35
 * value = "CLOUD-PAYMENT-SERVICE":表示Eureka中的提供者的服务器暴露出的服务名
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

  /**
   * 直接对接的是提供者锁暴露出来的接口地址
   * @param id
   * @return
   */
  @GetMapping("/payment/get/{id}")
  CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
