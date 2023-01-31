package sonarqube_demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sonarqube_demo.controller.MessageController;

@SpringBootTest
class SonarQubeDemo1ApplicationTests {

	@Autowired
	MessageController controller;
	
	@Test
	void contextLoads() {
		String message = controller.getMessage();
		Assertions.assertNull(message);
	}
	
}
