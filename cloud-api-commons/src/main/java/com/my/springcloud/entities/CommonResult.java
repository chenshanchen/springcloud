package com.my.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leofs
 * @author chenshan
 * @date 2020-05-11 13:33
 */
//@Data
//@AllArgsConstructor // 相当于全部参数的构造器
//@NoArgsConstructor // 相当于无参构造器
/**
 * 展示给前端的 json 封装的 Result
 * 404 not-found
 */
public class CommonResult <T>{

  private Integer code;
  private String message;
  private T data;

  public CommonResult(Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public CommonResult() {}

  public CommonResult(Integer code, String message) {
    this(code,message,null);
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}