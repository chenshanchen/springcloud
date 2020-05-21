package com.springcloud.service;

/**
 * @author chenshan
 * @date 2020-05-14 10:45
 */
public interface HystrixService {

  /**
   * 成功
   * @param id
   * @return
   */
  String paymentInfo_OK(Integer id);

  /**
   * 超时
   * @param id
   * @return
   */
  String paymentInfo_TimeOut(Integer id);

  /**
   * 服务熔断
   * @param id
   * @return
   */
  String paymentCircuitBreaker(Integer id);
}
