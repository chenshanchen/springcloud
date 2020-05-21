package com.my.springcloud.service.impl;

import com.my.springcloud.dao.PaymentDao;
import com.my.springcloud.entities.Payment;
import com.my.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenshan
 * @date 2020-05-11 13:52
 */
@Service
public class PaymentServiceImpl implements PaymentService {

  @Resource
  private PaymentDao paymentDao;

  @Override
  public int create(Payment payment) {
    return paymentDao.create(payment);
  }

  @Override
  public Payment getPaymentById(Long id) {
    return paymentDao.getPaymentById(id);
  }
}
