package com.my.springcloud.service;

import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author chenshan
 * @date 2020-06-02 16:32
 * 提供 PaymentOpenFeignService 接口中的兜底方法
 * 关掉所有的提供者，则会调用该兜底方法
 */
@Component
public class PaymentFallbackService implements PaymentOpenFeignService {
  @Override
  public CommonResult<Payment> paymentSQL(Long id) {
    return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
  }
}
