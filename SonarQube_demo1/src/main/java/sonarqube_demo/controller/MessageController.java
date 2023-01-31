package sonarqube_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sonarqube_demo.service.MessageServiceImpl;

@RestController
public class MessageController {

	@Autowired
	MessageServiceImpl service;

	@GetMapping("/message")
	public String getMessage() {
		return service.getMessage();
		
	}
}
