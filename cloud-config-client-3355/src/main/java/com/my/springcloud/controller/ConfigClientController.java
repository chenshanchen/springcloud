package com.my.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenshan
 * @date 2020-05-20 13:32
 */

@RestController
@RefreshScope //刷新
public class ConfigClientController {

  @Value("${config.info}")
  private String configInfo;

  @GetMapping("/configInfo")
  public String ConfigInfo(){

    return configInfo;
  }
}
