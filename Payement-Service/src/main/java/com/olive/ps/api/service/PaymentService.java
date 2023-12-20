package com.olive.ps.api.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.olive.ps.api.entity.Payment;
import com.olive.ps.api.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
    private PaymentRepository paymentRepository;
    
    //Logger logger= LoggerFactory.getLogger(PaymentService.class);
    
    public Payment doPayment(Payment payment)  {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        //logger.info("Payment-Service Request : {}",new ObjectMapper().writeValueAsString(payment));

        return paymentRepository.save(payment);
    }


    public String paymentProcessing(){
        //api should be 3rd party payment gateway (paypal,paytm...)
        return new Random().nextBoolean()?"success":"false";
    }


    public Payment findPaymentHistoryByOrderId(int orderId) {
        Payment payment=paymentRepository.findByOrderId(orderId);
        //logger.info("paymentService findPaymentHistoryByOrderId : {}",new ObjectMapper().writeValueAsString(payment));
        return payment ;
    }
	
}
