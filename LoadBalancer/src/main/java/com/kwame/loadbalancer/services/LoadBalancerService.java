package com.kwame.loadbalancer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadBalancerService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private final WebClient client = WebClient.builder().build();

    @Autowired
    private DiscoveryClient discoveryClient;

    public String sayHello()
    {
        String serviceId = "kwame-server";
        ServiceInstance instance;
        while (true)
        {
            instance = loadBalancerClient.choose(serviceId);
            if(isHealthy(serviceId, instance)) break;
            try { Thread.sleep(1000);} catch (Exception ignored){}
        }
        String serviceurl = instance.getUri().toString();
        return client.get().uri(serviceurl).retrieve().bodyToMono(String.class).block();
    }

    public boolean isHealthy(String serviceId, ServiceInstance instance)
    {
        List<ServiceInstance> healthyInstances = discoveryClient.getInstances(serviceId);
        Optional<ServiceInstance> matchingInstance = healthyInstances.stream()
                .filter(inst -> inst.getInstanceId().equals(instance.getInstanceId()))
                .findFirst();
        return matchingInstance.isPresent();
    }
}
