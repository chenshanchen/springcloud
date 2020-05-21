package com.my.springcloud.controller;

import com.my.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author chenshan
 * @date 2020-05-14 13:29
 */

@RestController
/**
 * @DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
 * 设置全局的服务降级的兜底的方法 payment_Global_FallbackMethod()
 * ①.如果在方法上只标注了 @HystrixCommand ,则服务降级走 payment_Global_FallbackMethod()
 * ②.如果在方法上明确标注了 @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Method",...) 则服务降级走 fallbackMethod=""中的方法
 */
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
  @Resource
  private PaymentHystrixService paymentHystrixService;

  @GetMapping("/consumer/payment/hystrix/ok/{id}")
  public String paymentInfo_OK(@PathVariable("id") Integer id){
    String result = paymentHystrixService.paymentInfo_OK(id);
    return result;
  }

  /**
   * 注意：服务的降级一般都在 客户端 上配置
   * 客户端中若想启动 @HystrixCommand 这个注解：
   * ①。需要在 application.yml 文件中将 feign.hystrix.enable 改为 true：
   * feign:
   *   hystrix:
   *     enabled: true
   * ②。需要在主启动类上添加 @EnableHystrix 注解
   * @param id
   * @return
   */
  @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Method",commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
  })
//  @HystrixCommand
  @GetMapping("/consumer/payment/hystrix/timeout/{id}")
  public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
    String result = paymentHystrixService.paymentInfo_TimeOut(id);
    System.out.println(new Date() + "============" + result);
    return result;

  }

  public String paymentInfo_TimeOut_Method(@PathVariable("id") Integer id){
    return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
  }

//  //下面是全局fallback方法
//  public String payment_Global_FallbackMethod(){
//    return "Global异常处理信息，请稍后再试,(┬＿┬)";
//  }


}
