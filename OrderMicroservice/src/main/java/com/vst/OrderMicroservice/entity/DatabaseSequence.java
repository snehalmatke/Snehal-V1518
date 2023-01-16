package com.vst.OrderMicroservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="databasesequence")
public class DatabaseSequence {


	private String id;
	private int seq;
}

