package com.vst.OrderMicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.OrderMicroservice.common.TransactionResponse;
import com.vst.OrderMicroservice.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

	TransactionResponse findByOrderId(Order order);

}
