package com.jms.JmsIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
	 @Autowired
	  private JmsTemplate jmsTemplate;

	  public void sendMessage(String message) {
		System.out.println("Message Send Started-MessageProducer" + message);
	    jmsTemplate.convertAndSend("test.queue", message);
	    System.out.println("Message Send end-MessageProducer" + message);
	  }

}
