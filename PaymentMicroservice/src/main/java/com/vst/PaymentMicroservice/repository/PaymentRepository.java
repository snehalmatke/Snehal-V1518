package com.vst.PaymentMicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.PaymentMicroservice.entity.Payment;

public interface PaymentRepository extends MongoRepository<Payment, Integer>{

	
}
