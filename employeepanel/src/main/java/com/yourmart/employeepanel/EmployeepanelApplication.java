package com.yourmart.employeepanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EmployeepanelApplication {

	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeepanelApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeepanelApplication.class, args);
	}

}
