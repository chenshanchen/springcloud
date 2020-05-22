package com.my.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chenshan
 * @date 2020-05-22 9:34
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

  @Value("${server.port}")
  private String serverPort;

  @StreamListener(Sink.INPUT)
  public void receiverMessage(Message<String> message){
    System.out.println("消费者2号，接受：" + message.getPayload() + "\t serverPort: " + serverPort);
  }

}
