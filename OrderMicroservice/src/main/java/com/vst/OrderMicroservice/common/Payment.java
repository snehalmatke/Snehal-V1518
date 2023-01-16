package com.vst.OrderMicroservice.common;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
	
	@Id
	int paymentId;
	String paymentStatus;
	String transactionId;
	
	int oredrId;
	String amount;
}
