package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableZuulProxy
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ZullGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullGatewayApplication.class, args);
	}

}
