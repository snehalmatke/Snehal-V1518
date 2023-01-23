package com.vst.KafkaProject.service;

import org.apache.kafka.common.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.vst.KafkaProject.model.User;
import com.vst.KafkaProject.repository.KafkaRepository;

@Service
public class ProducerService {

//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	
	@Autowired
	KafkaRepository repo;
	
//	public void sendMessageToTopic(String message) {
//		kafkaTemplate.send("SecondTopic", message);
//	}
	
	
	public void sendMessageToTopic(User user) {
		//Message<User> msg= new Message;
		kafkaTemplate.send("UserData", user);
		}

	public User save(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}
}
