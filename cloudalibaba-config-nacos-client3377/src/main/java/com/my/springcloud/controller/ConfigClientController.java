package com.my.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenshan
 * @date 2020-05-25 14:06
 */
@RestController
@RefreshScope //支持 Nacos 的自动刷新功能
public class ConfigClientController {

  @Value("${config.info}")
  private String configInfo;

  @GetMapping("/config/info")
  public String ConfigInfo() {
    return configInfo;
  }
}
