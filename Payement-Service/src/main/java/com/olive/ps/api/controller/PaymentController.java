package com.olive.ps.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olive.ps.api.entity.Payment;
import com.olive.ps.api.service.PaymentService;

@RestController
@RequestMapping("/payement")
public class PaymentController {
	
	@Autowired 
	private PaymentService paymentService;
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment)
	{
		return paymentService.doPayment(payment);
		
	}
	

}
