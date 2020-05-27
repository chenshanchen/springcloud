package com.my.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenshan
 * @date 2020-05-26 14:38
 */
@RestController
public class FlowLimitController {

  @GetMapping("/testA")
  public String testA(){
    return "testA...";
  }

  @GetMapping("/testB")
  public String testB(){
    return "testB...";
  }
}
