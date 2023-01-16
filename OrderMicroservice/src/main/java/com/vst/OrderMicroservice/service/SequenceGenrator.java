package com.vst.OrderMicroservice.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.vst.OrderMicroservice.entity.DatabaseSequence;


@Service
public class SequenceGenrator {

	@Autowired
	MongoOperations mongoOperation;
	
	public int getSequenceNumber(String sequenceName) {
		Query query = new Query(Criteria.where("id").is(sequenceName));
		Update update = new Update().inc("seq", 1);
		DatabaseSequence counter = mongoOperation.findAndModify(query, update, options().returnNew(true).upsert(true),
				DatabaseSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}
}
