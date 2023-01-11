package com.vst.host.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "databaseSquence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseSequence {

	@Id
	private String id;
	private int seq;

}
