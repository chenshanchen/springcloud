package com.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author chenshan
 * @date 2020-05-14 10:46
 */
@Service
public class HystrixServiceImpl implements HystrixService {

  @Override
  public String paymentInfo_OK(Integer id) {

    return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈"  ;
  }

  @Override
  /**
   * 服务降级：
   * commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"}：代表服务最多只等待3秒中
   * fallbackMethod = "paymentInfo_TimeOutHandler" ： 表示如果当前服务不可用：超时或者出现异常，则走 paymentInfo_TimeOutHandler() 这个方法
   *
   * 若想启动 @HystrixCommand 注解，需要在主启动类上添加  @EnableCircuitBreaker 注解
   */
  @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
  })
  public String paymentInfo_TimeOut(Integer id) {
    int timeNum = 3000;
    try {
      TimeUnit.MILLISECONDS.sleep(timeNum);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

//    int timeNum = 10;
    return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"呜呜呜"+" 耗时(秒)"+timeNum;
  }

  /**
   * 该方法为 paymentInfo_TimeOut() 的服务降级的兜底方法，除了方法名其他参数和 paymentInfo_TimeOut() 保持一致
   * @param id
   * @return
   */
  public String paymentInfo_TimeOutHandler(Integer id){
    return "线程池："+Thread.currentThread().getName()+"      8001网络繁忙，请稍后再试！";
  }


  /**
   * ################################# 服务熔断
   */

  /**
   * @HystrixCommand 中断路器的意思是：
   * 在时间窗口 10秒的时间里请求 10 次，失败率达到 60%,则断路器跳闸
   * @param id
   * @return
   */
  @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler",commandProperties = {
          @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
          @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 失败率达到多少后跳闸
  })
  @Override
  public String paymentCircuitBreaker(Integer id) {

    //当 id 为负数的时候抛出异常，fallback(服务降级)
    if (id < 0){
      throw new RuntimeException("***id 不能为负数");
    }

    //使用 hutool 工具包来获取 随机数
    String serialNumber = IdUtil.simpleUUID();

    return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
  }

  public String paymentCircuitBreakerHandler(Integer id){
    return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
  }

}
