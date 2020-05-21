package com.my.springcloud.controller;

import com.my.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenshan
 * @date 2020-05-21 17:35
 */
@RestController
public class SendMessageController {

  @Resource
  private IMessageProvider messageProvider;

  @GetMapping("/sendMessage")
  public String sendMessage(){
    return messageProvider.send();
  }
}
