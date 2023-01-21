//package com.vst.Cloud_gateway;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import reactor.core.publisher.Mono;
//
//@RestController
//public class FallbackController {
//
//	@RequestMapping("/orderFallBack")
//	public Mono<String> orderServicefallBack(){
//		return Mono.just("order service is talking to long to respond or is down. Please try again later");
//		
//	}
//	@RequestMapping("/paymentFallback")
//	public Mono<String> paymentServiceFallBack(){
//		return Mono.just("payment service is talking too long to respond or is down. Please try again later");
//		
//	}
//}
