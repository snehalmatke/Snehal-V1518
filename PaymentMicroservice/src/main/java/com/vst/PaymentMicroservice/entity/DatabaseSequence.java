package com.vst.PaymentMicroservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="databasesequence")
public class DatabaseSequence {


	private String paymentId;
	private int seq;
}
