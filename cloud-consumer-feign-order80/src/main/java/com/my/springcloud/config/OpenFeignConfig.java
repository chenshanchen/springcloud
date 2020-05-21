package com.my.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenshan
 * @date 2020-05-14 9:53
 *
 * 日志级别：
 * NONE：默认的，不显示任何日志
 * BASIC：仅记录请求方法、URL、响应状态码及执行时间
 * HEADERS：除了 BASIC 中定义的信息之外，还有请求和响应的头信息
 * FULL：除了 HEADERS 中定义的信息之外，还有请求和响应的正文及元数据
 */

@Configuration
public class OpenFeignConfig {

  @Bean
  Logger.Level feignLoggerLevel(){
    return Logger.Level.FULL;
  }
}

/**
 * 结果日志：
 * 2020-05-14 10:02:17.701 DEBUG 9844 --- [p-nio-80-exec-2] c.m.s.service.PaymentFeignService        : [PaymentFeignService#getPaymentById] <--- HTTP/1.1 200 (688ms)
 * 2020-05-14 10:02:17.701 DEBUG 9844 --- [p-nio-80-exec-2] c.m.s.service.PaymentFeignService        : [PaymentFeignService#getPaymentById] connection: keep-alive
 * 2020-05-14 10:02:17.702 DEBUG 9844 --- [p-nio-80-exec-2] c.m.s.service.PaymentFeignService        : [PaymentFeignService#getPaymentById] content-type: application/json
 * 2020-05-14 10:02:17.702 DEBUG 9844 --- [p-nio-80-exec-2] c.m.s.service.PaymentFeignService        : [PaymentFeignService#getPaymentById] date: Thu, 14 May 2020 02:02:17 GMT
 * 2020-05-14 10:02:17.702 DEBUG 9844 --- [p-nio-80-exec-2] c.m.s.service.PaymentFeignService        : [PaymentFeignService#getPaymentById] keep-alive: timeout=60
 * 2020-05-14 10:02:17.702 DEBUG 9844 --- [p-nio-80-exec-2] c.m.s.service.PaymentFeignService        : [PaymentFeignService#getPaymentById] transfer-encoding: chunked
 * 2020-05-14 10:02:17.702 DEBUG 9844 --- [p-nio-80-exec-2] c.m.s.service.PaymentFeignService        : [PaymentFeignService#getPaymentById]
 * 2020-05-14 10:02:17.703 DEBUG 9844 --- [p-nio-80-exec-2] c.m.s.service.PaymentFeignService        : [PaymentFeignService#getPaymentById] {"code":200,"message":"查询订单成功,serverPort: 8001","data":{"id":1,"serial":"tom"}}
 * 2020-05-14 10:02:17.703 DEBUG 9844 --- [p-nio-80-exec-2] c.m.s.service.PaymentFeignService        : [PaymentFeignService#getPaymentById] <--- END HTTP (91-byte body)
 * 2020-05-14 10:02:18.323  INFO 9844 --- [erListUpdater-0] c.netflix.config.ChainedDynamicProperty  : Flipping property: CLOUD-PAYMENT-SERVICE.ribbon.ActiveConnectionsLimit to use NEXT property: niws.loadbalancer.availabilityFilteringRule.activeConnectionsLimit = 2147483647
 */