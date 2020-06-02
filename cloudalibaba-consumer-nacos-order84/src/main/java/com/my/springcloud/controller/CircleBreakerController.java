package com.my.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author chenshan
 * @date 2020-06-02 14:28
 */
@RestController
public class CircleBreakerController {

  @Value("${service-url.nacos-user-service}")
  private String serviceUrl;
  @Resource
  private RestTemplate restTemplate;

  /**
   * fallback = "handlerFallback":负责业务异常
   * blockHandler = "blockHandler"：负责sentinel控制台配置违规
   * exceptionsToIgnore：用于指定哪些异常被排除掉，不会计入异常统计中，也不会进入 fallback 逻辑中，而是会原样抛出
   * @param id
   * @return
   */
  @GetMapping("/consumer/fallback/{id}")
  @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
  public CommonResult<Payment> fallback(@PathVariable Long id){
    CommonResult<Payment> result = restTemplate.getForObject(serviceUrl + "/paymentSQL/" + id, CommonResult.class, id);

    if(id == 4){
      throw new IllegalArgumentException("IllegalArgumentException,非法参数异常...");
    }else if(result.getData() == null){
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
