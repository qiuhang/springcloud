package com.qiuhang.springcloud.lb;

import cn.hutool.core.collection.ConcurrentHashSet;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.lb
 * @ClassName: MYLB
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/16 10:34
 * @Version: 1.0
 */
@Component
public class MYLB implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);


    public final int getAndIncement(){
        int current,next;
        do{
            current=this.atomicInteger.get();
            next=current>2147483647?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第几次访问："+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncement() % serviceInstanceList.size();
        System.out.println(index);
        return serviceInstanceList.get(index);
    }

    @Override
    public ServiceInstance random(List<ServiceInstance> serviceInstanceList) {
        Random random = new Random();
        int index =random.nextInt(2)%serviceInstanceList.size();
        System.out.println(index);
        ConcurrentHashSet concurrentHashSet = new ConcurrentHashSet();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        HashSet hashSet = new HashSet();
        hashSet.add("1");
        return serviceInstanceList.get(index);
    }
}
