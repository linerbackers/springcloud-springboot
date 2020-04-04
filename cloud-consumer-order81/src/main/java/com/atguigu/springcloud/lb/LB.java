package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 仿照轮询源码，自己手写一个
 */
@Component
public class LB implements LoadBalancer {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    public final int getAndIncrement(){
        //代表当前值
        int current;
        //代表下一个值
        int next;
        //采用自旋锁的方式配合CAS
        do{
            current=this.atomicInteger.get();
            next=current>Integer.MAX_VALUE?0:current+1;
        }while(!this.atomicInteger.compareAndSet(current,next));
            return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() %  serviceInstances.size();
        return serviceInstances.get(index);
    }
}
