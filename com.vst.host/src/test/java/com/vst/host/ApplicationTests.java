package com.vst.host;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vst.host.model.HostDetails;
import com.vst.host.service.HostServiceImpl;
import com.vst.host.util.ExcelReader;

@SpringBootTest
class ApplicationTests {

	@Autowired
	HostServiceImpl hostservice;
	
	@Test
		void contextLoads() {   
		ExcelReader obj = new ExcelReader();
		List<HostDetails> hostdetails = obj.HostDetailsList();
		System.out.println(hostdetails);
		for (int i = 0; i < hostdetails.size(); i++) {
	
			Assertions.assertEquals(true,hostservice.saveHostDetails(hostdetails.get(i)));
		}
	}}
		
	
//		@Test
//		void contextLoads() {  
//		AnotherExcelReader obj = new AnotherExcelReader();
//		List <HostDetails> hostdetails = obj.hostTest();
//		System.out.println(hostdetails);
//		for (int i = 0; i < hostdetails.size(); i++) {
//			Assertions.assertEquals(true, hostservice.saveHostDetails(hostdetails.get(i)));
//		}
//	}
//	}


