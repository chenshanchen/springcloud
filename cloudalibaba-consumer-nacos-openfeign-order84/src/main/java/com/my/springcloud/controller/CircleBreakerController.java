package com.my.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import com.my.springcloud.service.PaymentOpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenshan
 * @date 2020-06-02 16:35
 */
@RestController
public class CircleBreakerController {

  @Resource
  private PaymentOpenFeignService paymentOpenFeignService;

  @GetMapping("/consumer/paymentSQL/{id}")
  @SentinelResource(value = "paymentSQL",fallback = "handlerFallback",blockHandler = "blockHandler")
  public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
    CommonResult<Payment> result = paymentOpenFeignService.paymentSQL(id);
    if(id == 4){
      throw new IllegalArgumentException("IllegalArgumentException,非法参数异常...");
    } else if(result.getData() == null){
      throw new NullPointerException("NullPointerException,该 ID 没有对应记录，控指针异常...");
    }
    return result;
  }

  /**
   * fallback 兜底方法
   * @param id
   * @param e
   * @return
   */
  public CommonResult handlerFallback(@PathVariable Long id,Throwable e){
    Payment payment = new Payment(id,"null");
    return new CommonResult(444,"兜底异常 handlerFallback,exception内容 "+e.getMessage(),payment);
  }

  /**
   * blockHandler 兜底方法
   * @param id
   * @param blockException
   * @return
   */
  public CommonResult blockHandler(@PathVariable Long id, BlockException blockException){
    Payment payment = new Payment(id,"null");
    return new CommonResult(445,"blockHandler-sentinel限流,无此流水：blockException"+ blockException.getMessage(),payment);
  }
}
