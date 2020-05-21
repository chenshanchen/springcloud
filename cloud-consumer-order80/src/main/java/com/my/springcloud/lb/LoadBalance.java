package com.my.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author chenshan
 * @date 2020-05-13 9:54
 */
public interface LoadBalance {

  /**
   * 得到执行任务的服务器的实例
   * @param serviceInstances 收集服务器中有多少可以提供服务的机器:通过 discoveryClient.getInstances(String name)来获取
   * @return 返回使用第几台机器来执行任务
   */
  ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
