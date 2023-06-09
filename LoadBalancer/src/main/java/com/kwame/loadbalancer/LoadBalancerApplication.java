package com.kwame.loadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class LoadBalancerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerApplication.class, args);
	}
}
