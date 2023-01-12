package com.vst.KafkaProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.KafkaProject.service.ProducerService;

@RestController
public class KafkaController {

	@Autowired
	ProducerService producerService;
	
	@GetMapping("/producer")
	public void getmessageFromClient(@RequestParam("message") String message) {
		
		producerService.sendMessageToTopic(message);
	}
}
