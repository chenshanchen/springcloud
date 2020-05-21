package com.my.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenshan
 * @date 2020-05-13 10:01
 */
@Component
public class MyLoadBalance implements LoadBalance {

  /**
   * AtomicInteger:线程安全的Integer,初始值为0
   */
  private AtomicInteger atomicInteger = new AtomicInteger(0);

  /**
   * final:表示继承不可修改的方法
   * 使用 自旋锁 + CAS算法来获取到下一次访问的次数 (JUC高级中优雅的算法，不需要使用锁)
   * Integer.MAX_VALUE = 2147483647
   *   this.atomicInteger.compareAndSet(current,next)：就是 CAS 算法
   *  期望值是 current,修改的值是 next.
   *  如果期望值(current)和修改值(next)不一样则跳出自旋锁返回修改值(next)
   *  否则，继续自旋。
   * @return 返回第几次访问
   */
  public final int getAndIncrement(){
    int current;
    int next;
    do{
      //获取当前的值
      current = this.atomicInteger.get();
      next = current > Integer.MAX_VALUE ? 0 : current + 1;
    }while (!this.atomicInteger.compareAndSet(current,next));
    System.out.println("****访问次数： " + next);
    return next;
  }

  /**
   * 负载均衡之轮循的算法:
   * rest接口第几次访问数 % 服务器集群总数量 = 实际调用服务器位置下标
   * 注意：每次重启服务后rest接口计数从1开始
   * @return 返回实际调用的服务器
   */
  @Override
  public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
    //得到实际调用服务器位置下标
    int index = getAndIncrement() % serviceInstances.size();
    return serviceInstances.get(index);
  }
}
