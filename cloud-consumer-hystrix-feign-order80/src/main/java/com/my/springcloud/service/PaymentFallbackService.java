package com.my.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

/**
 * @author chenshan
 * @date 2020-05-14 15:59
 *
 * 通过新建一个 PaymentFallbackService类来实现 PaymentHystrixService 接口，
 * 为该接口中的所有方法提供一个降级方法。
 * 为了能够调用改方法，需在 PaymentHystrixService 接口的 @FeignClient 中配置 fallback 属性：
 * @FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
 * 解决了卸载一起的业务混乱问题
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
  @Override
  public String paymentInfo_OK(Integer id) {
    return "PaymentFallbackService paymentInfo_OK 网络繁忙，请销后再试！";
  }

  @Override
  public String paymentInfo_TimeOut(Integer id) {
    return "PaymentFallbackService paymentInfo_TimeOut 网络繁忙，请销后再试！";
  }
}
