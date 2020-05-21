package com.my.springcloud.controller;

import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import com.my.springcloud.lb.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenshan
 * @date 2020-05-11 15:40
 */

@RestController
public class OrderController {

//  public static final String PAYMENT_URL = "http://localhost:8001";
  /**
   * 消息的提供者是集群，所以接受者不能写死提供者的地址，需要借助 负载均衡
   * 应该去获取 Eureka 集群中暴露在外面的 hostname 来进行负载均衡
   * 为了能实现负载均衡：需要在 ApplicationContextConfig 中 添加 @LoadBalanced 注解
   */
  public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
  @Resource
  private RestTemplate restTemplate;
  @Resource
  private LoadBalance loadBalance;
  @Resource
  private DiscoveryClient discoveryClient;

  @GetMapping("/consumer/payment/create")
  public CommonResult<Payment> create(Payment payment){
    return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment, CommonResult.class);
  }

  @GetMapping("/consumer/payment/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
    return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id ,CommonResult.class);
  }

  @GetMapping("/consumer/payment/lb")
  public String getPaymentLb(){
    //获取 serverId 为 CLOUD-PAYMENT-SERVICE 的所有存在的服务器
    List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

    ServiceInstance instances = loadBalance.instances(serviceInstances);
    //http://192.168.93.1:8002/http://192.168.93.1:8001
    System.out.println("url:"+instances.getUri());

    return restTemplate.getForObject(instances.getUri() + "/payment/lb",String.class);
  }



}
