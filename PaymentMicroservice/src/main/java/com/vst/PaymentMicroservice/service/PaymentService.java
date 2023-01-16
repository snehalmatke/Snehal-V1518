package com.vst.PaymentMicroservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.PaymentMicroservice.entity.Payment;
import com.vst.PaymentMicroservice.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepo;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepo.save(payment);
	}
	public String paymentProcessing() {
		//random method to set the payment status
		//api should be third party payment getway (paypal,paytm)
		return new Random().nextBoolean()?"success":"false";
	}
}
