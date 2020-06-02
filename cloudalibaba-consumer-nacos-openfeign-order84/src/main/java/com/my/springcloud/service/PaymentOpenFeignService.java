package com.my.springcloud.service;

import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenshan
 * @date 2020-06-02 16:26
 * 带 @FeignClient 注解的业务接口
 * 提供者中 service 中的接口方法
 * value = "nacos-payment-provider":指的是提供者的 nacos 中的服务名(也是 application.yml 中的 spring.application.name)
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentOpenFeignService {

  @GetMapping("/paymentSQL/{id}")
  CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
