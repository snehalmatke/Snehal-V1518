package com.vst.KafkaProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.KafkaProject.model.User;

public interface KafkaRepository extends MongoRepository<User, Integer>{

}
