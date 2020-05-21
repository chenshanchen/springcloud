package com.my.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author chenshan
 * @date 2020-05-21 17:55
 */
@Component
@EnableBinding(Sink.class) //定义消息接收的管道
public class ReceiveMessageListenerController {

  @Value("${server.port}")
  private String serverPort;

  /**
   * @param message
   * Message<String> message:在 8801 的发送消息中 发送的是 String 类型的 serial：
   *      String serial = UUID.randomUUID().toString();
   *      output.send(MessageBuilder.withPayload(serial).build());
   * 所以，Message<String> 是 String 类型的泛型
   *
   * @StreamListener(Sink.INPUT) : @StreamListener:监听队列，用于消费者的队列的消息接收
   */
  @StreamListener(Sink.INPUT)
  public void receiverMessage(Message<String> message){
    System.out.println("消费者1号，接受：" + message.getPayload() + "\t serverPort: " + serverPort);
  }
}
