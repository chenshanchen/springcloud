package com.my.springcloud.dao;

import com.my.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenshan
 * @date 2020-05-11 13:43
 */
@Mapper
public interface PaymentDao {

  int create(Payment payment);

  Payment getPaymentById(@Param("id") Long id);
}
