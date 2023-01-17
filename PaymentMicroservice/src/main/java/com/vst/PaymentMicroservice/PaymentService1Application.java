package com.vst.PaymentMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentService1Application {

	public static void main(String[] args) {
		SpringApplication.run(PaymentService1Application.class, args);
	}

}
