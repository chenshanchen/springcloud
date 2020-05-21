package com.my.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenshan
 * @date 2020-05-20 16:48
 */
@RestController
@RefreshScope
public class ConfigClientController {

  @Value("${server.port}")
  private String serverPort;

  @Value("${config.info}")
  private String configInfo;

  @GetMapping("/configInfo")
  public String ConfigInfo(){
    return "serverPort:" + serverPort + "\t" + "configInfo:" + configInfo;
  }
}
