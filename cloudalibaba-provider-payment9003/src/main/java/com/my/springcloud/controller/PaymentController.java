package com.my.springcloud.controller;

import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author chenshan
 * @date 2020-06-02 13:59
 */
@RestController
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;
  /**
   * 模拟数据库
   */
  public static HashMap<Long, Payment> hashMap = new HashMap<>();
  static{
    hashMap.put(1L,new Payment(1L,"28a8c1e3bc2742d8848569891fb42181"));
    hashMap.put(2L,new Payment(2L,"bba8c1e3bc2742d8848569891ac32182"));
    hashMap.put(3L,new Payment(3L,"6ua8c1e3bc2742d8848569891xt92183"));
  }

  @GetMapping("/paymentSQL/{id}")
  public CommonResult<Payment> paymentSQL(@PathVariable Long id){

    Payment payment = hashMap.get(id);
    CommonResult<Payment> result = new CommonResult(200,"from mysql,serverPort:  "+serverPort,payment);
    return result;
  }


}
