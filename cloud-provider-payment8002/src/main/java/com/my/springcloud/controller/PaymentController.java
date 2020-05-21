package com.my.springcloud.controller;

import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import com.my.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenshan
 * @date 2020-05-11 13:53
 */
@RestController
@Slf4j
public class PaymentController {

  @Resource
  private PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @Resource
  private DiscoveryClient discoveryClient;

  @PostMapping("/payment/create")
  public CommonResult<Payment> create(@RequestBody Payment payment){
    int result = paymentService.create(payment);
    if(result > 0 ){
      return new CommonResult(result,"插入订单成功,serverPort: " + serverPort ,result);
    }else {
      return new CommonResult(result,"插入失败",null);
    }
  }

  @GetMapping("/payment/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
    Payment payment = paymentService.getPaymentById(id);
    if(payment != null){
      return new CommonResult(200,"查询订单成功,serverPort: " + serverPort ,payment);
    }else {
      return new CommonResult<>(444,"查无此结果",null);
    }
  }

  @GetMapping("payment/discovery")
  public Object discovery(){
    List<String> services = discoveryClient.getServices();
    for (String service : services) {
      System.out.println("**********"+ service +"*********");
    }

    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-ORDER-CONSUMER");
    for (ServiceInstance instance : instances) {
      System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
    }
    return this.discoveryClient;
  }

  /**
   * 获取该服务端的端口
   * @return
   */
  @GetMapping("/payment/lb")
  public String paymentLb(){
    return serverPort;
  }
}
