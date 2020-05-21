package com.my.springcloud.service.impl;

import com.my.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author chenshan
 * @date 2020-05-21 17:27
 * 这个不再使用 @Service 注解，即不再通过 dao来获取消息
 * 而是将消息 【通过 source(消息输出)->channel(通道)->binder(绑定器)】发送到 消息中间件：
 */
@EnableBinding(Source.class) //定义消息的推送(发送者)的管道是输出消息
public class MessageProviderImpl implements IMessageProvider {


  @Resource
  private MessageChannel output;  //消息发送管道

  @Override
  public String send() {
    String serial = UUID.randomUUID().toString();
    //将需要发送的消息(serial)发送给了消息中间件
    output.send(MessageBuilder.withPayload(serial).build());
    System.out.println("*****serial" + serial);
    return serial;
  }
}
