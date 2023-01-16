package com.vst.PaymentMicroservice.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vst.PaymentMicroservice.entity.Payment;
import com.vst.PaymentMicroservice.service.PaymentService;
import com.vst.PaymentMicroservice.service.SequenceGenerator;

@RestController
@RequestMapping("/payment")
class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
    @Autowired
	SequenceGenerator sequenceGenerator; 
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) {
	payment.setPaymentId(sequenceGenerator.getSequenceNumber(payment.SEQUENCE_NAME));
		return paymentService.doPayment(payment);
		
	}
	
	
	
}
