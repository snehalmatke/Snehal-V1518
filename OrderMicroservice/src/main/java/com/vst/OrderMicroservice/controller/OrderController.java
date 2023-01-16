package com.vst.OrderMicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vst.OrderMicroservice.common.TransactionRequest;
import com.vst.OrderMicroservice.common.TransactionResponse;
import com.vst.OrderMicroservice.entity.Order;
import com.vst.OrderMicroservice.service.OrderService;
import com.vst.OrderMicroservice.service.SequenceGenrator;


@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	SequenceGenrator sequenceGenerator;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		
		
		Order order = request.getOrder();
		order.setId(sequenceGenerator.getSequenceNumber(Order.SEQUENCE_NAME));
		request.setOrder(order);
		
		return orderService.saveOrder(request);
	}
	
	
	
}
