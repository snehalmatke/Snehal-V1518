package com.vst.PaymentMicroservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "payment")
public class Payment {

	@Transient
    public static final String SEQUENCE_NAME = "PAYMENT";
	
	@Id
	int paymentId;
	String paymentStatus;
	String transactionId;
	
	int oredrId;
	String amount;
}
