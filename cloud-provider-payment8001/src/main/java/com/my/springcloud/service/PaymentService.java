package com.my.springcloud.service;

import com.my.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenshan
 * @date 2020-05-11 13:49
 */
public interface PaymentService {

  int create(Payment payment);

  Payment getPaymentById(@Param("id") Long id);
}
