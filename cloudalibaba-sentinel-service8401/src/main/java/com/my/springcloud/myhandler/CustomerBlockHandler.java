package com.my.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.my.springcloud.entities.CommonResult;

/**
 * @author chenshan
 * @date 2020-06-02 10:56
 *
 * 全局的兜底方法
 */
public class CustomerBlockHandler {

  public static CommonResult handleException(BlockException exception) {
    return new CommonResult(4444, "自定义限流处理信息....CustomerBlockHandler-----1");

  }

  public static CommonResult handleException2(BlockException exception) {
    return new CommonResult(4444, "自定义限流处理信息....CustomerBlockHandler------2");

  }
}
