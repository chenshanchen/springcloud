package com.my.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import com.my.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenshan
 * @date 2020-06-02 10:22
 */
@RestController
public class RateLimitController {

  /**
   * @SentinelResource：就是相当于 @HystrixCommand，用于出现问题自定义配置兜底的方法
   * blockHandler = "handleException"：若 sentinel 限流出现问题，就会调用自定义的 handleException()
   * @return
   */
  @GetMapping("/byResource")
  @SentinelResource(value = "byResource",blockHandler = "handleException")
  public CommonResult byResource(){
    return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
  }

  public CommonResult handleException(BlockException exception){
    return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
  }

  /**
   * 使用 全局的自定义方法
   * blockHandlerClass = CustomerBlockHandler.class:指定使用自定义全局兜底方法的类
   * blockHandler = "handleException2"：指定该类中某个兜底方法
   * @return
   */
  @GetMapping("/customerBlockHandler")
  @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handleException2")
  public CommonResult customerBlockHandler(){
    return new CommonResult(200,"按客戶自定义",new Payment(2020L,"serial003"));
  }
}
