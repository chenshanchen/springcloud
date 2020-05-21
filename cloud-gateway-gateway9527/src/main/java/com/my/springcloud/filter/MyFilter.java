package com.my.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author chenshan
 * @date 2020-05-15 14:37
 */
@Component
public class MyFilter implements GlobalFilter, Ordered {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

    System.out.println(new Date() + "**********MyFilter**********");

    //判断访问地址的第一个参数带有 key 为 uname
    String uname = exchange.getRequest().getQueryParams().getFirst("uname");
    if(uname == null){
      System.out.println("用户名为空，非法用户！");
      //设置返回页面为 HttpStatus.NOT_ACCEPTABLE
      exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
      return exchange.getResponse().setComplete();
    }

    return chain.filter(exchange);
  }

  /**
   * 执行顺序
   * @return return 的值越小，越先执行
   */
  @Override
  public int getOrder() {
    return 0;
  }
}
