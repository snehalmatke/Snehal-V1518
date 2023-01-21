package com.vst.OrderMicroservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class Order {

	@Transient
    public static final String SEQUENCE_NAME = "order";
	
	@Id
	int id;
	
	String name;
	int qty;
	String price;
}
