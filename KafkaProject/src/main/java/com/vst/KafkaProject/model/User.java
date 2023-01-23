package com.vst.KafkaProject.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "kafkauser")
public class User {
	
	int id;
	String name;
	String address;
	String emailId;

}
