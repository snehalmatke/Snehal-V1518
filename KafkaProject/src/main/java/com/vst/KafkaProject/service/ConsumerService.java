package com.vst.KafkaProject.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@KafkaListener(topics = "UserData", groupId = "TestGroup")     
	public void listenToTopic(String recevideMessage) {
		System.out.println("The message recevide is" + recevideMessage);
	}
	
	
}
