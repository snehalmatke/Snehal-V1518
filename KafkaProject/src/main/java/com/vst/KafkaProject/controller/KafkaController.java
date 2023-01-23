package com.vst.KafkaProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.KafkaProject.model.User;
import com.vst.KafkaProject.repository.KafkaRepository;
import com.vst.KafkaProject.service.ProducerService;

@RestController
public class KafkaController {

	@Autowired
	ProducerService producerService;
	
	
	
//	@GetMapping("/producer")
//	public String getmessageFromClient(@RequestParam("message") String message) {
//		
//		producerService.sendMessageToTopic(message);
//		return "data publish";
//	
	@PostMapping("/user")
	public User save(@RequestBody User user) {
		return producerService.save(user);
		
	}
	
	@GetMapping("/producer")
	public User getmessageFromClient(@RequestParam("user") User user) {
		producerService.sendMessageToTopic(user);
		return user;
}}
