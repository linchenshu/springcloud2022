package com.lcs.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author linchenshu
 * @date 2022/7/5 14:13
 **/
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
