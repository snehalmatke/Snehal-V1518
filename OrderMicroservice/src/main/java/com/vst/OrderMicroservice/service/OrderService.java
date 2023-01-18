package com.vst.OrderMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vst.OrderMicroservice.common.Payment;
import com.vst.OrderMicroservice.common.TransactionRequest;
import com.vst.OrderMicroservice.common.TransactionResponse;
import com.vst.OrderMicroservice.entity.Order;
import com.vst.OrderMicroservice.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Transactional
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response= "";
		Order order = request.getOrder();
		System.out.println(order);
		
		Payment payment = request.getPayment();
		System.out.println(payment);

		payment.setOrderId(order.getId());
		System.out.println(payment);

		payment.setAmount(order.getPrice());
		System.out.println(payment);

		//rest call for template 
		Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
		System.out.println(paymentResponse);

		response = paymentResponse.getPaymentStatus().equals("success")?"payment processing sucessfull and order placed":"there is a failure in payment api , order added to cart";
		System.out.println(response);
		orderRepository.save(order);
		System.out.println(order);
		 return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
		 
	}

	
}
