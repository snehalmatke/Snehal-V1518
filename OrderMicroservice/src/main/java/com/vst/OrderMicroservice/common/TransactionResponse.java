package com.vst.OrderMicroservice.common;

import com.vst.OrderMicroservice.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

	private Order order;
	private String amount;
	private String transactionId;
	private String message;
}
