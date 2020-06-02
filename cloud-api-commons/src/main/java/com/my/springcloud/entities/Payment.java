package com.my.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenshan
 * @date 2020-05-11 13:32
 */
@Data
//@AllArgsConstructor //自动生成全参构造器
//@NoArgsConstructor //自动生成无参构造器
public class Payment implements Serializable {
  private Long id;
  private String serial;

  public Payment(Long id, String serial) {
    this.id = id;
    this.serial = serial;
  }

  public Payment() {
  }
}
